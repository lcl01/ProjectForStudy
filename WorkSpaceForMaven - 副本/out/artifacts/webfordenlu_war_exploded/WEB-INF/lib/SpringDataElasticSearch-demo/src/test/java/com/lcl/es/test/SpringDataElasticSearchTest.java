package com.lcl.es.test;

import com.lcl.es.service.ArticleService;
import com.lcl.pojo.Article;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringDataElasticSearchTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TransportClient client;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Test
    public void createIndex(){
        elasticsearchTemplate.createIndex(Article.class);
        elasticsearchTemplate.putMapping(Article.class);
    }
    @Test
    public void saveArticle(){
        Article article = new Article();
        article.setId(100);
        article.setTitle("运行SpringData Elasticsearch");
        article.setContent("Spring Data ElasticSearch 基于 spring data API 简化 elasticSearch操作，将原始操作elasticSearch的客户端API 进行封装 \\n\" +\n" +
                "                \"    Spring Data为Elasticsearch Elasticsearch项目提供集成搜索引擎");
        articleService.save(article);
    }
    @Test
    public void update(){
        Article article = new Article();
        article.setId(120);
        article.setTitle("elasticSearch 3.0版本发布...更新");
        article.setContent("ElasticSearch是一个基于Lucene的搜索服务器。它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口");
        articleService.save(article);
    }
    @Test
    public void delete(){
        Article article = new Article();
        article.setId(100);
        articleService.delete(article);
    }
    @Test
    public void save100(){
        for (int i = 0; i < 100; i++) {
            Article article = new Article();
            article.setId(i);
            article.setTitle(i+"elasticSearch 3.0版本发布..，更新");
            article.setContent(i+"ElasticSearch是一个基于Lucene的搜索服务器。它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口");
            articleService.save(article);
        }
    }
    @Test
    public void findAll(){
        Iterable<Article> iterable = articleService.findAll();
        for(Article article:iterable){
            System.out.println(article);
        }
    }
    @Test
    public  void findAllPage(){
        Pageable pageable = PageRequest.of(1, 10);
        Page<Article> page = articleService.findAll(pageable);
        System.out.println("总记录数："+page.getTotalElements());
        for(Article article:page.getContent()){
            System.out.println(article);
        }
    }

}
