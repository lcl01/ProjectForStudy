package com.itheima.es.test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.es.pojo.Article;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class TestElasticSearch {
    @Test
    public void testCreateIndex() throws Exception {
        TransportClient client = new PreBuiltTransportClient(org.elasticsearch.common.settings.Settings.EMPTY);
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        client.addTransportAddress(address);
        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "2");
        Map <String, Object> map = new HashMap <String, Object>();
        map.put("id", 2);
        map.put("title", "你好世界chggh");
        map.put("content", "你好上课的几年功夫可视对讲关键时fdhgdh刻");

        indexRequestBuilder.setSource(map);
        IndexResponse response = indexRequestBuilder.get();
        System.out.println(response);
        client.close();


    }

    @Test
    public void testCreateIndex1() throws Exception {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        client.addTransportAddress(address);
        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "2");
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("id", 2)
                .field("title", "2adknfjks")
                .field("content", "2ElasticSearch是一个基于Lucene的搜索服务器")
                .endObject();
        indexRequestBuilder.setSource(builder);
        IndexResponse response = indexRequestBuilder.get();
        System.out.println(response);
        client.close();

    }

    @Test
    public void testGetById2() throws Exception {
        /**
         * 1.创建客户端访问对象-TransportClient
         * Settings表示集群的设置
         * Settings.EMPTY：表示没有集群的配置(单节点)
         * Settings.builder().build()：表示连接的是集群环境(多节点)
         */
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);
        //查询
        GetResponse response = client.prepareGet("blog", "article", "1").get();
        //7.输出执行结果-response.sout()
        System.out.println("文章json: " + response.getSourceAsString());
        System.out.println("获取title:" + response.getSource().get("title"));
        //8.关闭客户端-client.close()
        client.close();
    }

    @Test
    public void testRequest3() throws Exception {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);
        SearchResponse searchResponse = client.prepareSearch("blog").setTypes("article")
                .setQuery(QueryBuilders.matchAllQuery()).get();
        SearchHits hits = searchResponse.getHits();
        System.out.println("总记录数" + hits.getTotalHits());
        for (SearchHit hit : hits.getHits()) {
            System.out.println("文章json" + hit.getSourceAsString());
            System.out.println(hit.getSource().get("title"));
            System.out.println("_______________________________");
        }
        client.close();
    }

    @Test
    public void test4() throws Exception {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);
        //查询所有
        SearchResponse response = client.prepareSearch("blog").setTypes("article")
                .setQuery(QueryBuilders.queryStringQuery("你好").field("content")).get();
        SearchHits hits = response.getHits();
        System.out.println("中记录数" + hits.getTotalHits());
        for (SearchHit searchHitFields : hits.getHits()) {
            System.out.println("文章json" + searchHitFields.getSourceAsString());
            System.out.println("title" + searchHitFields.getSource().get("title"));
        }
        client.close();
    }

    @Test
    public void testWildcardQuery() throws Exception {
        //1.创建客户端访问对象-TransportClient
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

        //查询所有
        SearchResponse response = client.prepareSearch("blog").setTypes("article")
            /*
             * "*"：表示所有的任意的多个字符组成
             * "?"：表示1个任意的字符
             * */
                .setQuery(QueryBuilders.wildcardQuery("content", "*?*")).get();
        //7.输出执行结果-response.sout()
        SearchHits hits = response.getHits();
        System.out.println("总记录数：" + hits.getTotalHits());
        for (SearchHit hit : hits.getHits()) {
            System.out.println("文章json: " + hit.getSourceAsString());
            System.out.println("获取title:" + hit.getSource().get("title"));
            System.out.println("-------------------------------------------------");
        }
        //8.关闭客户端-client.close()
        client.close();
    }

    @Test
    public void tes05() throws Exception {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        client.addTransportAddress(address);
        //创建索引
        client.admin().indices().prepareCreate("blog3").get();
//        client.admin().indices().prepareDelete("blog1").get();
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .startObject("article")
                .startObject("properties")
                .startObject("id")
                .field("type", "long")
                .field("store", "false")
                .field("index", true)
                .endObject()
                .startObject("title")
                .field("type", "text")
                .field("store", false)
                .field("index", true)
                .field("analyzer", "ik_smart")
                .endObject()
                .startObject("title")
                .field("type", "text")
                .field("store", false)
                .field("index", true)
                .field("analyzer", "ik_smart")
                .endObject()
                .startObject("content")
                .field("type", "text")
                .field("store", false)
                .field("index", true)
                .field("ananluzer", "ik_smart")
                .endObject()
                .endObject()
                .endObject()
                .endObject();
        PutMappingRequest request = Requests.putMappingRequest("blog3").type("article").source(builder);
        client.admin().indices().putMapping(request);
        client.close();

    }

    @Test
    public void test06() throws Exception {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

        //方式2：XContentBuilder(推荐)
        //4.准备索引-client.prepareIndex(索引名,类型名,文档id)
        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "3");
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()  //{
                .field("id", 3)
                .field("title", "什么是Elasticsearch")
                .field("content", "ElasticSearch是一个基于Lucene的搜索服务器")
                .endObject(); //}
        indexRequestBuilder.setSource(builder);

        //6.执行保存索引与文档-indexRequestBuilder.get()
        IndexResponse response = indexRequestBuilder.get();
        //7.输出执行结果-response.sout()
        System.out.println(response);
        //8.关闭客户端-client.close()
        client.close();
    }

    @Test
    public void test08() throws Exception {
        Article article = new Article();
        article.setId(2l);
        article.setTitle("2什么是Elasticsearch");
        article.setContent("2ElasticSearch是一个基于Lucene的搜索服务器");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(article);
        System.out.println(json);
        String str = "{\"id\":2,\"title\":\"2什么是Elasticsearch\",\"content\":\"32ElasticSearch是一个基于Lucene的搜索服务器\"}";
        Article article1 = mapper.readValue(str, Article.class);
        System.out.println(article1);

    }

    @Test
    public void test07() throws Exception {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

        //方式2：XContentBuilder(推荐)
        //4.准备索引-client.prepareIndex(索引名,类型名,文档id)
        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "2");
        Article article = new Article();
        article.setId(2L);
        article.setTitle("2什么是Elasticsearch");
        article.setContent("2ElasticSearch是一个基于Lucene的搜索服务器");
        ObjectMapper mapper = new ObjectMapper();
        indexRequestBuilder.setSource(mapper.writeValueAsString(article), XContentType.JSON);
        IndexResponse response = indexRequestBuilder.get();
        System.out.println(response);
        client.close();
    }

    @Test
    public void test8() throws Exception {
        PreBuiltTransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        client.addTransportAddress(address);
//        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "2");
        Article article = new Article();
        article.setId(2L);
        article.setTitle("3【修改】什么是Elasticsearch");
        article.setContent("3【修改】ElasticSearch是一个基于Lucene的搜索服务器");
        ObjectMapper mapper = new ObjectMapper();
        ActionFuture <UpdateResponse> response = client.update(new UpdateRequest("blog", "article", "2").doc(mapper.writeValueAsString(article), XContentType.JSON));
        System.out.println(response);
        client.close();
    }

    @Test
    public void test9() throws Exception {
        PreBuiltTransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        client.addTransportAddress(address);
////        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "2");
//        Article article = new Article();
//        article.setId(2L);
//        article.setTitle("3【修改】什么是Elasticsearch");
//        article.setContent("3【修改】ElasticSearch是一个基于Lucene的搜索服务器");
//        ObjectMapper mapper = new ObjectMapper();
//        ActionFuture<UpdateResponse> response=client.update(new UpdateRequest("blog", "article", "2").doc(mapper.writeValueAsString(article),XContentType.JSON));
        DeleteResponse response = client.prepareDelete("blog", "article", "2").get();
        System.out.println(response);
        client.close();
    }

    @Test
    public void test10() throws Exception {
        PreBuiltTransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        client.addTransportAddress(address);
////        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "2");
//        Article article = new Article();
//        article.setId(2L);
//        article.setTitle("3【修改】什么是Elasticsearch");
//        article.setContent("3【修改】ElasticSearch是一个基于Lucene的搜索服务器");
//        ObjectMapper mapper = new ObjectMapper();
//        ActionFuture<UpdateResponse> response=client.update(new UpdateRequest("blog", "article", "2").doc(mapper.writeValueAsString(article),XContentType.JSON));
//        DeleteResponse response=client.prepareDelete("blog", "article", "2").get();
//        System.out.println(response);
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        ObjectMapper mapper = new ObjectMapper();
        for (long i = 0; i < 100; i++) {
            Article article = new Article();
            article.setId(i);
            article.setTitle("什么是Elasticsearch?" + i);
            article.setContent("ElasticSearch是一个基于Lucene的搜索服务器" + i);
            //追加文档
            bulkRequestBuilder.add(client.prepareIndex("blog", "article", i + "")
                    .setSource(mapper.writeValueAsString(article), XContentType.JSON));
        }
        BulkResponse bulkItemResponses = bulkRequestBuilder.get();
        System.out.println(bulkItemResponses);
        client.close();
    }

    @Test
    public void testQuery() throws Exception {
        //1.创建客户端访问对象-TransportClient
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

        SearchResponse response = client.prepareSearch("blog").setTypes("article")
                //.setQuery(QueryBuilders.matchAllQuery()).get();  //查询所有
                /**
                 * 字符串查询
                 * QueryBuilders.queryStringQuery("搜索")默认匹配所有域
                 * 如果如果添加.field("content")：表示只在content字段进行搜索
                 */
                //.setQuery(QueryBuilders.queryStringQuery("搜索").field("content")).get();
                .setQuery(QueryBuilders.termQuery("content", "搜索")).get(); //词条查询
        //7.输出执行结果-response.sout()
        SearchHits hits = response.getHits();
        System.out.println("总记录数：" + hits.getTotalHits());
        for (SearchHit hit : hits.getHits()) {
            System.out.println("文章json: " + hit.getSourceAsString());
            System.out.println("获取title:" + hit.getSource().get("title"));
            System.out.println("-------------------------------------------------");
        }
        //8.关闭客户端-client.close()
        client.close();
    }

    @Test
    public void testQuery01() throws Exception {
        //1.创建客户端访问对象-TransportClient
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

//        SearchResponse response = client.prepareSearch("blog").setTypes("article")
        //.setQuery(QueryBuilders.matchAllQuery())  //查询所有
        /**
         * 字符串查询
         * QueryBuilders.queryStringQuery("搜索")默认匹配所有域
         * 如果如果添加.field("content")：表示只在content字段进行搜索
         */
        //.setQuery(QueryBuilders.queryStringQuery("搜索").field("content"))

        //.setQuery(QueryBuilders.termQuery("content","搜索")) //词条查询

        //通配符查询：试试"*8"与"?8"的区别
        //.setQuery(QueryBuilders.wildcardQuery("content", "?8"))

        //.setQuery(QueryBuilders.fuzzyQuery("content", "elasticseerch")) //相似度查询

//                .setQuery(QueryBuilders.rangeQuery("id").from(1).to(5)) //范围查询(日期、数值...)
//                .get();
        SearchResponse response = client.prepareSearch("blog").setTypes("article")
                .setQuery(QueryBuilders.boolQuery()
//                        .must(QueryBuilders.termQuery("content","elasticsearch"))
                                .must(QueryBuilders.wildcardQuery("content", "elasticsearch"))
                                .must(QueryBuilders.rangeQuery("id").from(1).to(5))
                ).get();
        //7.输出执行结果-response.sout()
        SearchHits hits = response.getHits();
        System.out.println("总记录数：" + hits.getTotalHits());
        ObjectMapper mapper = new ObjectMapper();
        for (SearchHit hit : hits.getHits()) {
            Article article = mapper.readValue(hit.getSourceAsString(), Article.class);
            System.out.println(article);
            System.out.println("-------------------------------------------------");
        }
        //8.关闭客户端-client.close()
        client.close();
    }

    @Test
    public void testQueryPage() throws Exception {
        //1.创建客户端访问对象-TransportClient
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

        SearchResponse response = client.prepareSearch("blog").setTypes("article")
                .setQuery(QueryBuilders.boolQuery()
                                .must(QueryBuilders.termQuery("content", "Elasticsearch".toLowerCase()))
                        //.must(QueryBuilders.rangeQuery("id").from(1).to(5))
                )
                //设置分页参数
                //setFrom()：从第几条开始检索，默认是0。
                //setSize():每页查询记录数
                .setFrom(0).setSize(2)
                //设置排序-addSort(域名,排序方式asc|desc)
                .addSort("id", SortOrder.DESC)
                .get();
        //7.输出执行结果-response.sout()
        SearchHits hits = response.getHits();
        System.out.println("总记录数：" + hits.getTotalHits());
        ObjectMapper mapper = new ObjectMapper();
        for (SearchHit hit : hits.getHits()) {
            Article article = mapper.readValue(hit.getSourceAsString(), Article.class);
            System.out.println(article);
            System.out.println("-------------------------------------------------");
        }
        //8.关闭客户端-client.close()
        client.close();

    }
    @Test
    public void test11()throws  Exception{
        PreBuiltTransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        client.addTransportAddress(address);
        SearchRequestBuilder requestBuilder = client.prepareSearch("blog").
                setTypes("article").setQuery(QueryBuilders.termQuery("title","elasticsearch"));
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("title");
        requestBuilder.highlighter(highlightBuilder);
        SearchResponse searchResponse = requestBuilder.get();
        SearchHits hits = searchResponse.getHits();
        for (SearchHit hit : hits) {
            System.out.println("String方式打印文档搜索内容:");
            System.out.println(hit.getSourceAsString());
            System.out.println("Map方式打印高亮内容");
            System.out.println(hit.getHighlightFields());
            System.out.println("遍历高亮集合，打印高亮片段:");
            Text[] titles = hit.getHighlightFields().get("title").fragments();
            for (Text title : titles) {
                System.out.println(title);
            }
            System.out.println("--------------------------");

        }
        client.close();
    }


}
