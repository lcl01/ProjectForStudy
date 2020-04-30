package com.changgou.search.service.impl;

import com.alibaba.fastjson.JSON;
import com.changgou.goods.feign.SkuFeign;
import com.changgou.goods.pojo.Sku;
import com.changgou.search.dao.SkuEsMapper;
import com.changgou.search.pojo.SkuInfo;
import com.changgou.search.service.SkuService;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Steven
 * @version 1.0
 * @description com.changgou.search.service.impl
 * @date 2019-11-3
 */
@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuEsMapper skuEsMapper;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private SkuFeign skuFeign;
    @Override
    public void importSku() {
        //远程调用，获取sku列表
        List<Sku> skuList = skuFeign.findByStatus("1").getData();
        //把sku转换成skuinfo
        List<SkuInfo> skuInfos = JSON.parseArray(JSON.toJSONString(skuList), SkuInfo.class);
        //规格嵌套域-.........
        for (SkuInfo skuInfo : skuInfos) {
            Map specMap = JSON.parseObject(skuInfo.getSpec(), Map.class);
            skuInfo.setSpecMap(specMap);
        }
        skuEsMapper.saveAll(skuInfos);
    }

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Override
    public Map search(Map<String, String> searchMap) {
        Map map = new HashMap();
        //构建查询条件
        NativeSearchQueryBuilder builder = builderBasicQuery(searchMap);
//        1、根据条件查询商品列表
        searchList(builder, map);
//        //2、分组查询商品分类列表
//        searchCategoryList(builder,map);
//        //查询品牌列表
//        searchBrandList(builder,map);
//        searchSpec(builder,map);

        return map;
    }

    private void searchGroup(NativeSearchQueryBuilder builder, Map map) {
        builder.addAggregation(AggregationBuilders.terms("group_category").field("categoryName"));
        builder.addAggregation(AggregationBuilders.terms("group_brand").field("brandName"));
        builder.addAggregation(AggregationBuilders.terms("group_spec").field("spec.keyword").size(10000));
        AggregatedPage<SkuInfo> page = elasticsearchTemplate.queryForPage(builder.build(), SkuInfo.class);
        Aggregations aggregations = page.getAggregations();
        //1、提取分类结果
        List<String> categoryList = getGroupResult(aggregations, "group_category");
        map.put("categoryList", categoryList);
        //2、提取品牌结果
        List<String> brandList = getGroupResult(aggregations, "group_brand");
        map.put("brandList", brandList);
        //3、提取规格结果
        List<String> specList = getGroupResult(aggregations, "group_spec");
        //所有规格列表
        Map<String, Set<String>> specMap = new HashMap<>();
        for (String spec : specList) {
            //{"电视音响效果":"小影院","电视屏幕尺寸":"20英寸","尺码":"165"}
            //把spec的json串转换成Map<String,String>
            Map<String, String> tempMap = JSON.parseObject(spec, Map.class);
            //循环读取key与value，组装到结果集中
            for (String key : tempMap.keySet()) {
                Set<String> values = specMap.get(key);
                //如果当前key是第一次组装
                if(values == null){
                    values = new HashSet<String>();
                }
                //向结果value中追加一个元素
                values.add(tempMap.get(key));
                //规格结果集追加元素
                specMap.put(key, values);
            }
        }
        //8.返回分类数据列表-map.put("categoryList", categoryList)
        map.put("specMap", specMap);
    }

    private List <String> getGroupResult(Aggregations aggregations, String group_name) {
        //5.提取分组结果数据-stringTerms = aggregations.get(填入刚才查询时的别名)
        StringTerms stringTerms = aggregations.get(group_name);
        //6.定义分类名字列表-categoryList = new ArrayList<String>()
        List<String> specList = new ArrayList<String>();
        //7.遍历读取分组查询结果-stringTerms.getBuckets().for
        for (StringTerms.Bucket bucket : stringTerms.getBuckets()) {
            //7.1获取分类名字，并将分类名字存入到集合中-bucket.getKeyAsString()
            specList.add(bucket.getKeyAsString());
        }
        return specList;

    }


    private void searchSpec(NativeSearchQueryBuilder builder, Map map) {
        //1.设置分组域名-termsAggregationBuilder = AggregationBuilders.terms(别名).field(域名).size(查询记录数);
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("group_spec").field("spec.keyword").size(10000);
        //2.添加分组查询参数-builder.addAggregation(termsAggregationBuilder)
        builder.addAggregation(termsAggregationBuilder);
        //3.执行搜索-esTemplate.queryForPage(builder.build(), SkuInfo.class)
        AggregatedPage<SkuInfo> page = elasticsearchTemplate.queryForPage(builder.build(), SkuInfo.class);
        //4.获取所有分组查询结果集-page.getAggregations()
        Aggregations aggregations = page.getAggregations();
        //5.提取分组结果数据-stringTerms = aggregations.get(填入刚才查询时的别名)
        StringTerms stringTerms = aggregations.get("group_spec");
        //6.定义分类名字列表-categoryList = new ArrayList<String>()
        List<String> specList = new ArrayList<String>();
        //7.遍历读取分组查询结果-stringTerms.getBuckets().for
        for (StringTerms.Bucket bucket : stringTerms.getBuckets()) {
            specList.add(bucket.getKeyAsString());
        }
        //所有规格列表
        Map<String, Set<String>> specMap = new HashMap<>();
        //包装List<Spec>，组装成Map<String,Set>
        for (String spec : specList) {
            Map<String,String> tempMap = JSON.parseObject(spec, Map.class);
            for (String key : tempMap.keySet()) {
                Set <String> values = specMap.get(key);
                if (values==null) {
                     values = new HashSet <>();
                    //向结果value中追加一个元素
                    values.add(tempMap.get(key));
                    //规格结果集追加元素
                    specMap.put(key, values);
                }
            }
            map.put("specMap",specMap);
        }
        System.out.println(map.get("specMap"));


    }

    private void searchBrandList(NativeSearchQueryBuilder builder, Map map) {
        //1.设置分组域名-termsAggregationBuilder = AggregationBuilders.terms(别名).field(域名);
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("group_brand").field("brandName");
        //2.添加分组查询参数-builder.addAggregation(termsAggregationBuilder)
        builder.addAggregation(termsAggregationBuilder);
        //3.执行搜索-esTemplate.queryForPage(builder.build(), SkuInfo.class)
        AggregatedPage <SkuInfo> page = elasticsearchTemplate.queryForPage(builder.build(), SkuInfo.class);
        //4.获取所有分组查询结果集-page.getAggregations()
        Aggregations aggregations = page.getAggregations();
        //5.提取分组结果数据-stringTerms = aggregations.get(填入刚才查询时的别名)
        StringTerms stringTerms = aggregations.get("group_brand");
        //定义分类名字列表-category=new Arraylist<String>()
        ArrayList <String> brandList = new ArrayList <String>();
        //遍历读取分组查询结果-StringTerms getBuckets().for
        for (StringTerms.Bucket bucket : stringTerms.getBuckets()) {
            brandList.add(bucket.getKeyAsString());
        }
        //返回分类数据列表-map.put("categoryList",catogoryList)
        map.put("brandList",brandList);
    }

    /**
     * 分组查询商品分类列表
     * @param builder  查询条件
     * @param map 查询结果集
     */
    private void searchCategoryList(NativeSearchQueryBuilder builder, Map map) {
        //1.设置分组域名-termsAggregationBuilder = AggregationBuilders.terms(别名).field(域名);
        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("group_category").field("categoryName");
        //2.添加分组查询参数-builder.addAggregation(termsAggregationBuilder)
        builder.addAggregation(termsAggregationBuilder);
        //3.执行搜索-esTemplate.queryForPage(builder.build(), SkuInfo.class)
        AggregatedPage<SkuInfo> page = elasticsearchTemplate.queryForPage(builder.build(), SkuInfo.class);
        //4.获取所有分组查询结果集-page.getAggregations()
        Aggregations aggregations = page.getAggregations();
        //5.提取分组结果数据-stringTerms = aggregations.get(填入刚才查询时的别名)
        StringTerms stringTerms = aggregations.get("group_category");
        //6.定义分类名字列表-categoryList = new ArrayList<String>()
        List<String> categoryList = new ArrayList<String>();
        //7.遍历读取分组查询结果-stringTerms.getBuckets().for
        for (StringTerms.Bucket bucket : stringTerms.getBuckets()) {
            //7.1获取分类名字，并将分类名字存入到集合中-bucket.getKeyAsString()
            categoryList.add(bucket.getKeyAsString());
        }
        //8.返回分类数据列表-map.put("categoryList", categoryList)
        map.put("categoryList", categoryList);
        System.out.println(map.get("categoryList"));
    }

    /**
     * 根据查询条件查询商品列表
     * @param builder 条件
     * @param map 返回对象
     */
    private void searchList(NativeSearchQueryBuilder builder, Map map) {
//        //3、获取NativeSearchQuery搜索条件对象-builder.build()
//        NativeSearchQuery query = builder.build();
//        //4.查询数据-esTemplate.queryForPage(条件对象,搜索结果对象)
//        AggregatedPage<SkuInfo> page = elasticsearchTemplate.queryForPage(query, SkuInfo.class);
//        //5、包装结果并返回
//        map.put("rows", page.getContent());
//        map.put("total", page.getTotalElements());
//        map.put("totalPages", page.getTotalPages());

        HighlightBuilder.Field hField = new HighlightBuilder.Field("name");
        hField.preTags("<em:style='color:blue;'>");
        hField.postTags("</em>");
        hField.fragmentSize(100);
        builder.withHighlightFields(hField);
        NativeSearchQuery query = builder.build();
        //高亮查询方式
        //h2.高亮数据读取-AggregatedPage<SkuInfo> page = esTemplate.queryForPage(query, SkuInfo.class, new SearchResultMapper(){})
        AggregatedPage <SkuInfo> page = elasticsearchTemplate.queryForPage(query, SkuInfo.class, new SearchResultMapper() {
            @Override
            public <T> AggregatedPage <T> mapResults(SearchResponse response, Class <T> clazz, Pageable pageable) {
                List <T> list = new ArrayList <>();
                for (SearchHit hit : response.getHits()) {
                    String json = hit.getSourceAsString();
                    SkuInfo skuInfo = JSON.parseObject(json, SkuInfo.class);
                    HighlightField nameHighlight= hit.getHighlightFields().get("name");
                    if (nameHighlight !=null) {
                        StringBuffer buffer = new StringBuffer();
                        for (Text fragname : nameHighlight.getFragments()) {
                            buffer.append(fragname);
                        }
                        skuInfo.setName(buffer.toString());

                    }
                    list.add((T) skuInfo);
                }
                return new AggregatedPageImpl <T>(list,pageable,response.getHits().getTotalHits());
            }
        });
        //5、包装结果并返回
        map.put("rows", page.getContent());
        map.put("total", page.getTotalElements());
        map.put("totalPages", page.getTotalPages());
        searchGroup(builder,map);
        int pageNum = query.getPageable().getPageNumber();
        map.put("pageNum",pageNum);
        int pageSize = query.getPageable().getPageSize();
        map.put("pageSize",pageSize);

    }

    /**
     * 构建基本查询条件
     * @param searchMap
     * @return
     */
    private NativeSearchQueryBuilder builderBasicQuery(Map<String, String> searchMap) {
        //1、创建查询条件构建器-builder = new NativeSearchQueryBuilder()
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        //2、组装查询条件
        if(searchMap != null){
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

            //2.1关键字搜索-builder.withQuery(QueryBuilders.matchQuery(域名，内容))
            String keywords = searchMap.get("keywords") ==null ? "" : searchMap.get("keywords");
            if(StringUtils.isNotBlank(keywords)){
//                builder.withQuery(QueryBuilders.matchQuery("name", keyword));
                //查询name域
                boolQueryBuilder.must(QueryBuilders.matchQuery("name",keywords));

            }
            //2.2分页查询
            String category = searchMap.get("category") ==null ? "" : searchMap.get("category");
            if(StringUtils.isNotBlank(category)){
                boolQueryBuilder.must(QueryBuilders.termQuery("categoryName",category));

            }
            //2.3 品牌查询
            String brand = searchMap.get("brand") == null ? "" : searchMap.get("brand");
            if (StringUtils.isNotEmpty(brand)) {
                boolQueryBuilder.must(QueryBuilders.termQuery("brandName", brand));
            }
            for (String key : searchMap.keySet()) {
                if (key.startsWith("spec_")) {
//                    String specField="specMap."+key.substring(5) +".keyword";
//                    boolQueryBuilder.must(QueryBuilders.termQuery(specField,searchMap.get(key)));
                    String value=searchMap.get(key).replace("\\","");
                    boolQueryBuilder.filter(QueryBuilders.matchQuery("specMap."+key.substring(5)+".keyword",value));

                }
            }
            String price = searchMap.get("price") == null ? "" : searchMap.get("price");
            if(StringUtils.isNotEmpty(price)){
                //范围匹配搜索
                RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price");
                //解析前端传入的价格：0-500 ,500-1000,3000
                String[] split = price.split("-");
                //处理前面的价格:price >= 0
                boolQueryBuilder.must(rangeQueryBuilder.gte(split[0]));
                //如果解析结果大小1，说明传入的不是3000
                if(split.length > 1){
                    //price <= 500
                    boolQueryBuilder.must(rangeQueryBuilder.lte(split[1]));
                }
            }
            builder.withQuery(boolQueryBuilder);
            //当前页
            Integer page = searchMap.get("pageNum") == null ? 1 : new Integer(searchMap.get("pageNum"));
            Integer pageSize = 5;  //每页查询记录数
            PageRequest pageRequest = PageRequest.of(page, pageSize);
            builder.withPageable(pageRequest);
            String sortRule = searchMap.get("sortRule") == null ? "" : searchMap.get("sortRule");
            //排序域名
            String sortField = searchMap.get("sortField") == null ? "" : searchMap.get("sortField");
            if(StringUtils.isNotEmpty(sortField)){
                //fieldSort(域名)，order(排序方式)
                builder.withSort(SortBuilders.fieldSort(sortField).order(SortOrder.valueOf(sortRule)));
            }


        }
        return builder;
    }

}
