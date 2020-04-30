import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.es.bean.Article;
import com.sun.deploy.nativesandbox.comm.Request;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
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
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

public class TestElasticSearch {
    @Test
    public void testES() throws Exception {
        /**1.创建客户端访问对象-TransportClient*/
//2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
//3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
//4.准备索引-client.prepareIndex(索引名,类型名,文档id)
//5.准备数据(域与映射)-indexRequestBuilder.setSource(map)
//6.执行保存索引与文档-indexRequestBuilder.get()
//7.输出执行结果-response.sout()
//8.关闭客户端-client.close()
        /**
         * 1.创建客户端访问对象-TransportClient
         * Settings表示集群的设置
         * Settings.EMPTY：表示没有集群的配置(单节点)
         * Settings.builder().build()：表示连接的是集群环境(多节点)
         */
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-newInetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);
        //4.准备索引-client.prepareIndex(索引名,类型名,文档id)
        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "1");
        //5.准备数据(域与映射)-indexRequestBuilder.setSource(map)
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id",1);
        map.put("title","什么是Elasticsearch");
        map.put("content","Elasticearch是一个基于Lucene的搜素服务器");
        indexRequestBuilder.setSource(map);
        //6.执行保存索引与文档-indexRequestBuilder.get()
        IndexResponse response = indexRequestBuilder.get();
        //7.输出执行结果-response.sout()
        System.out.println(response);
        //8.关闭客户端-client.close()
        client.close();


    }
    @Test
    //创建索引
    public void testCreateIndex() throws Exception {
        /**
         * 1.创建客户端访问对象-TransportClient
         * Settings表示集群的设置
         * Settings.EMPTY：表示没有集群的配置(单节点)
         * Settings.builder().build()：表示连接的是集群环境(多节点)
         */
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
//2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);
        //方式1：map
        //4.准备索引-client.prepareIndex(索引名,类型名,文档id)
    /*IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "1");
    //5.准备数据(域与映射)-indexRequestBuilder.setSource(map)
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("id", 1);
    map.put("title", "什么是Elasticsearch?");
    map.put("content", "ElasticSearch是一个基于Lucene的搜索服务器");
    indexRequestBuilder.setSource(map);*/
        //方式2：XContentBuilder(推荐)
        //4.准备索引-client.prepareIndex(索引名,类型名,文档id)
        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "2");
        XContentBuilder builder = XContentFactory.jsonBuilder()
                .startObject()
                .field("id",2)
                .field("title","2什么是Elasticsearch")
                .field("content","2ElasticSearch是一个基于Lucene的搜索服务器")
                .endObject();
        indexRequestBuilder.setSource(builder);
        //6.执行保存索引与文档-indexRequestBuilder.get()
        IndexResponse response = indexRequestBuilder.get();
        //7.输出执行结果-response.sout()
        System.out.println(response);
        //8.关闭客户端-client.close()
        client.close();
    }
    @Test
    public void testGetById() throws Exception{
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
        GetResponse response = client.prepareGet("blog", "article", "2").get();
        //7.输出执行结果-response.sout()
        System.out.println("文章json: " + response.getSourceAsString());
        System.out.println("获取title:" + response.getSource().get("title"));
        //8.关闭客户端-client.close()
        client.close();
    }
    @Test
    public void testGetAll() throws Exception {
        //1.创建客户端访问对象-TransportClient
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);
        //查询所有
        SearchResponse response = client.prepareSearch("blog").setTypes("article").setQuery(QueryBuilders.matchAllQuery()).get();
        //7.输出执行结果-response.sout()
        SearchHits hits = response.getHits();
        System.out.println("总记录数" + hits.getTotalHits());
        for (SearchHit hit : hits) {
            System.out.println("文章json: " + hit.getSourceAsString());
            System.out.println("获取title:" + hit.getSource().get("title"));
            System.out.println("-------------------------------------------------");
        }
        client.close();

    }
    @Test
//    字符串查询(条件分词)
    public void testGetByString()throws Exception{
        //1.创建客户端访问对象-TransportClient
        PreBuiltTransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);
        //查询所有
        SearchResponse response = client.prepareSearch("blog").setTypes("article")
                /*QueryBuilders.queryStringQuery("搜索")默认匹配所有域
                 * 如果如果添加.field("content")：表示只在content字段进行搜索
                 * */
                .setQuery(QueryBuilders.queryStringQuery("搜索").field("content")).get();
        SearchHits hits = response.getHits();
        System.out.println("总记录数：" + hits.getTotalHits());
        for (SearchHit hit : hits.getHits()) {
            System.out.println("文章json: " + hit.getSourceAsString());
            System.out.println("获取title:" + hit.getSource().get("title"));
            System.out.println("-------------------------------------------------");
        }
        client.close();
    }

//   词条查询(条件不分词)
        @Test
        public void testTiaoJianBuFenCi()throws Exception{
            //1.创建客户端访问对象-TransportClient
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
            //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
            InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
            //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
            client.addTransportAddress(address);
            //查询所有
            SearchResponse response = client.prepareSearch("blog").setTypes("article")
            /*
             * QueryBuilders.queryStringQuery("搜索")默认匹配所有域
             * 如果如果添加.field("content")：表示只在content字段进行搜索
             * */
            //.setQuery(QueryBuilders.queryStringQuery("搜索").field("content")).get();
                    .setQuery(QueryBuilders.termQuery("content","搜索")).get();
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
//        4.2.5.模糊查询（通配符查询）
    public void testWildcardQuery()throws Exception{
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
                    .setQuery(QueryBuilders.wildcardQuery("content","*?*")).get();
            //7.输出执行结果-response.sout()
            SearchHits hits = response.getHits();
            System.out.println("总记录数：" + hits.getTotalHits());
            for (SearchHit hit : hits.getHits()) {
                System.out.println("文章json: " + hit.getSourceAsString());
                System.out.println("获取title:" + hit.getSource().get("title"));
                System.out.println("-------------------------------------------------");
            }
            client.close();
        }
        @Test
    public void testElasticsearchCRUD() throws Exception {
            //1.创建客户端访问对象-TransportClient
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
            //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
            InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
            //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
            client.addTransportAddress(address);
            //创建索引
//            client.admin().indices().prepareCreate("blog1").get();
            //删除索引
//            client.admin().indices().prepareDelete("blog1","blog3").get();
            client.admin().indices().prepareDelete("blog1").get();
            //8关闭客户端-client.close()
            client.close();


        }
        @Test
    public void testPutMappings() throws Exception {
            //1.创建客户端访问对象-TransportClient
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
            //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
            InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
            //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
            client.addTransportAddress(address);
            //创建索引
            client.admin().indices().prepareCreate("blog1").get();
            XContentBuilder builder = XContentFactory.jsonBuilder()
                    .startObject()
                    .startObject("article")
                    .startObject("properties")
                    .startObject("id")
                    .field("type", "long") //指定数据类型
                    .field("store", false)  //是否存储(默认就是false),使用默认的_score来存储
                    .field("index", true)    //是否创建索引，默认true
                    .endObject()
                    .startObject("title")
                    .field("type", "text")   //指定数据类型
                    .field("store", false)   //是否存储(默认就是false),使用默认的_score来存储
                    .field("index", true)     //是否创建索引，默认true
                    .field("analyzer", "ik_smart")   //使用ik最小切分方式作为分词器
                    .endObject()
                    .startObject("content")
                    .field("type", "text")  //指定数据类型
                    .field("store", false)  //是否存储(默认就是false),使用默认的_score来存储
                    .field("index", true)   //是否创建索引，默认true
                    .field("analyzer", "ik_smart")   //使用ik最小切分方式作为分词器
                    .endObject()
                    .endObject()
                    .endObject()
                    .endObject();
            PutMappingRequest request = Requests.putMappingRequest("blog1").type("article").source(builder);
            client.admin().indices().putMapping(request);
            //8.关闭客户端-client.close()
            client.close();

        }
        @Test
    public void testCreateDocument()throws Exception{
            /**1.创建客户端访问对象-TransportClient*/
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
            //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
            InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
            //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
            client.addTransportAddress(address);
            //方式2：XContentBuilder(推荐)
            //4.准备索引-client.prepareIndex(索引名,类型名,文档id)
            IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog1", "article", "1");
            XContentBuilder builder = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("id", 1)
                    .field("title", "什么是Elasticsearch")
                    .field("content", "ElasticSearch是一个基于Lucene的搜索服务器")
                    .endObject();
            indexRequestBuilder.setSource(builder);
            //6.执行保存索引与文档-indexRequestBuilder.get()
            IndexResponse response = indexRequestBuilder.get();
            //7.输出执行结果-response.sout()
            System.out.println(response);
            //8.关闭客户端-client.close()
            client.close();

        }
        @Test
    public void testJacksonMapper()throws Exception{
            Article article = new Article();
            article.setId(2L);
            article.setTitle("2什么是Elasticsearch");
            article.setContent("2ElasticSearch是一个基于Lucene的搜索服务器");
            ObjectMapper mapper = new ObjectMapper();
            //把对象转json串
            String json = mapper.writeValueAsString(article);
            System.out.println(json);
            String str = "{\"id\":3,\"title\":\"3什么是Elasticsearch\",\"content\":\"3ElasticSearch是一个基于Lucene的搜索服务器\"}";
            //把json字符串转对象
            Article article1=mapper.readValue(str,Article.class);
            System.out.println(article1);


        }
        @Test
    public void testCreateDocumentByArticle()throws Exception{
            /**1.创建客户端访问对象-TransportClient*/
            TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
            //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
            InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
            //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
            client.addTransportAddress(address);
            //方式2：XContentBuilder(推荐)
            //4.准备索引-client.prepareIndex(索引名,类型名,文档id)
            IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog1", "article", "2");
            Article article = new Article();
            article.setId(2L);
            article.setTitle("2什么是Elasticsearch");
            article.setContent("2ElasticSearch是一个基于Lucene的搜索服务器");
            //使用对象json串保存
            ObjectMapper mapper = new ObjectMapper();
            indexRequestBuilder.setSource(mapper.writeValueAsString(article), XContentType.JSON);
            //6.执行保存索引与文档-indexRequestBuilder.get()
            IndexResponse response = indexRequestBuilder.get();
            //7.输出执行结果-response.sout()
            System.out.println(response);
            //8.关闭客户端-client.close()
            client.close();

        }
//        1.4.3.2.使用prepareUpdate修改文档
    @Test
    public void testUpdateDocument() throws Exception{
        /**1.创建客户端访问对象-TransportClient*/
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

        //方案一：使用prepareIndex(推荐)
    /*//4.准备索引-client.prepareIndex(索引名,类型名,文档id)
    IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "2");
    Article article = new Article();
    article.setId(2L);
    article.setTitle("2-1什么是Elasticsearch");
    article.setContent("2-1ElasticSearch是一个基于Lucene的搜索服务器");
    //使用对象json串保存
    ObjectMapper mapper = new ObjectMapper();
    indexRequestBuilder.setSource(mapper.writeValueAsString(article), XContentType.JSON);
    //6.执行保存索引与文档-indexRequestBuilder.get()
    IndexResponse response = indexRequestBuilder.get();*/
        //方案二：使用prepareUpdate
        Article article = new Article();
        article.setId(2L);
        article.setTitle("2【修改】什么是Elasticsearch");
        article.setContent("2【修改】ElasticSearch是一个基于Lucene的搜索服务器");
        ObjectMapper mapper = new ObjectMapper();
        //更新文档
        UpdateResponse response = client.prepareUpdate("blog1", "article", "2")
                .setDoc(mapper.writeValueAsString(article), XContentType.JSON).get();
        //7.输出执行结果-response.sout()
        System.out.println(response);
        //8.关闭客户端-client.close()
        client.close();
    }
    @Test
//    1.4.3.3.直接使用update()修改文档
    public void testUpdateDocument01() throws Exception{
        /**1.创建客户端访问对象-TransportClient*/
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);
        //方案一：使用prepareIndex(推荐)
    /*//4.准备索引-client.prepareIndex(索引名,类型名,文档id)
    IndexRequestBuilder indexRequestBuilder = client.prepareIndex("blog", "article", "2");
    Article article = new Article();
    article.setId(2L);
    article.setTitle("2-1什么是Elasticsearch");
    article.setContent("2-1ElasticSearch是一个基于Lucene的搜索服务器");
    //使用对象json串保存
    ObjectMapper mapper = new ObjectMapper();
    indexRequestBuilder.setSource(mapper.writeValueAsString(article), XContentType.JSON);
    //6.执行保存索引与文档-indexRequestBuilder.get()
    IndexResponse response = indexRequestBuilder.get();*/
        //方案二：使用prepareUpdate
    /*Article article = new Article();
    article.setId(2L);
    article.setTitle("2【修改】什么是Elasticsearch");
    article.setContent("2【修改】ElasticSearch是一个基于Lucene的搜索服务器");
    ObjectMapper mapper = new ObjectMapper();
    //更新文档
    UpdateResponse response = client.prepareUpdate("blog", "article", "2")
            .setDoc(mapper.writeValueAsString(article), XContentType.JSON).get();*/

        //方案三：直接使用update()修改文档
        Article article = new Article();
        article.setId(2L);
        article.setTitle("3【修改】什么是Elasticsearch");
        article.setContent("3【修改】ElasticSearch是一个基于Lucene的搜索服务器");
        ObjectMapper mapper = new ObjectMapper();
        ActionFuture<UpdateResponse> response = client.update(new UpdateRequest("blog1", "article", "2")
                .doc(mapper.writeValueAsString(article), XContentType.JSON));
        //7.输出执行结果-response.sout()
        System.out.println(response);
        //8.关闭客户端-client.close()
        client.close();
    }
    @Test
    public void testDeleteDocument() throws Exception{
        /**1.创建客户端访问对象-TransportClient*/
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

        //方案一：通过prepareDelete 删除文档
//        DeleteResponse response = client.prepareDelete("blog1", "article", "2").get();
//方案二：直接使用delete() 删除文档
        DeleteResponse response = client.delete(new DeleteRequest("blog1", "article", "1")).get();

        //7.输出执行结果-response.sout()
        System.out.println(response);
        //8.关闭客户端-client.close()
        client.close();
    }
//1.5.1.批量导入
@Test
public void testCreateDocumentByArticle100() throws Exception{
    /**1.创建客户端访问对象-TransportClient*/
    TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
    //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
    InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
    //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
    client.addTransportAddress(address);
    //批量执行器
    BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
    //使用对象json串保存
    ObjectMapper mapper = new ObjectMapper();
    for (int i = 0; i < 100; i++) {
        Article article = new Article();
        article.setId((long) i);
        article.setTitle("什么是Elasticsearch?" + i);
        article.setContent("ElasticSearch是一个基于Lucene的搜索服务器" + i);
        bulkRequestBuilder.add(client.prepareIndex("blog1", "article", i+"")
                .setSource(mapper.writeValueAsString(article), XContentType.JSON));
    }
    //执行批量保存索引与文档
    BulkResponse responses = bulkRequestBuilder.get();
    //7.输出执行结果-response.sout()
    System.out.println(responses.status());
    //8.关闭客户端-client.close()
    client.close();

}
//查询文档
    @Test
    public void testQuery() throws Exception{
        //1.创建客户端访问对象-TransportClient
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

        SearchResponse response = client.prepareSearch("blog1").setTypes("article")
        //.setQuery(QueryBuilders.matchAllQuery()).get();  //查询所有
        /**
         * 字符串查询
         * QueryBuilders.queryStringQuery("搜索")默认匹配所有域
         * 如果如果添加.field("content")：表示只在content字段进行搜索
         */
        //.setQuery(QueryBuilders.queryStringQuery("搜索").field("content")).get();
                .setQuery(QueryBuilders.termQuery("content","搜索")).get(); //词条查询
        //7.输出执行结果-response.sout()
        SearchHits hits = response.getHits();
        System.out.println("总记录数：" + hits.getTotalHits());
        for (SearchHit hit : hits.getHits()) {
            System.out.println("文章json: " + hit.getSourceAsString());
            System.out.println("获取title:" + hit.getSource().get("title"));
            System.out.println("-------------------------------------------------");
        }
        client.close();
    }
    //查询文档
    @Test
    public void testQuerywendan() throws Exception{
        //1.创建客户端访问对象-TransportClient
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

        SearchResponse response = client.prepareSearch("blog1").setTypes("article")
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
                .setQuery(QueryBuilders.rangeQuery("id").from(1).to(5)) //范围查询(日期、数值...)
                .get();

//7.输出执行结果-response.sout()
        SearchHits hits = response.getHits();
        System.out.println("总记录数：" + hits.getTotalHits());
        ObjectMapper mapper = new ObjectMapper();
        for (SearchHit hit : hits.getHits()) {
            Article article=mapper.readValue(hit.getSourceAsString(),Article.class);
            System.out.println(article);
            System.out.println("--------------------------");

        }
        client.close();
    }
    /**
     * 组合查询
     * must(QueryBuilders) : AND，求交集
     * mustNot(QueryBuilders): NOT 不包含
     * should(QueryBuilders):OR ，求并集
     */
    @Test
    public void testBoolQuery() throws Exception{
        //1.创建客户端访问对象-TransportClient
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

        SearchResponse response = client.prepareSearch("blog1").setTypes("article")
                .setQuery(QueryBuilders.boolQuery()
                        .must(QueryBuilders.termQuery("content","elasticsearch"))
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
    //分页与排序
    @Test
    public void testQueryPage() throws Exception{
        //1.创建客户端访问对象-TransportClient
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);

        SearchResponse response = client.prepareSearch("blog").setTypes("article")
                .setQuery(QueryBuilders.boolQuery()
                                .must(QueryBuilders.termQuery("content","Elasticsearch".toLowerCase()))
                        //.must(QueryBuilders.rangeQuery("id").from(1).to(5))
                )//设置分页参数
                //setFrom()：从第几条开始检索，默认是0。
                //setSize():每页查询记录数
                .setFrom(0).setSize(20)
                //设置排序-addSort(域名,排序方式asc|desc)
                .addSort("id", SortOrder.ASC)
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
//1.7.3.高亮显示代码实现
    @Test
    public void testQueryHighlight() throws Exception{
        //1.创建客户端访问对象-TransportClient
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
        //2.创建Elasticsearch连接对象-new InetSocketTransportAddress(InetAddress.getByName(地址), 端口号)
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        //3.指定Elasticsearch连接地址与端口-client.addTransportAddress(address)
        client.addTransportAddress(address);
        //设置高亮参数
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        //设置前缀
        highlightBuilder.preTags("<em style='color:red'>");
        //设置后缀
        highlightBuilder.postTags("</em>");
        //设置高亮域
        highlightBuilder.field("content");
        SearchResponse response = client.prepareSearch("blog1").setTypes("article")
                .setQuery(QueryBuilders.boolQuery().must(QueryBuilders.termQuery("content", "Elasticsearch".toLowerCase())))
                //设置分页参数
                //setFrom()：从第几条开始检索，默认是0。
                //setSize():每页查询记录数
                .setFrom(0).setSize(20)
                .addSort("id", SortOrder.ASC)
                //高亮查询
                .highlighter(highlightBuilder).get();
        //7.输出执行结果-response.sout()
        SearchHits hits = response.getHits();
        System.out.println("总记录数：" + hits.getTotalHits());
        ObjectMapper mapper = new ObjectMapper();
        for (SearchHit hit : hits.getHits()) {
            Article article=mapper.readValue(hit.getSourceAsString(),Article.class);
            //读取高亮数据
            Text[] fragments = hit.getHighlightFields().get("content").fragments();
            String content="";
            //读取高亮碎片
            for (Text text : fragments) {
                content+=text;
            }
            article.setContent(content);
            System.out.println(article);
            System.out.println("---------------");

        }
        //8.关闭客户端-client.close()
        client.close();
    }

}

