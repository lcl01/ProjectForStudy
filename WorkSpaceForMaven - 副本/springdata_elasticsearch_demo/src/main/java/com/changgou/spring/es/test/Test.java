package com.changgou.spring.es.test;

import com.changgou.spring.es.service.ArticleService;
import com.changgou.spring.es.bean.Article;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private ArticleService articleService;
    @org.junit.Test
    public void testCreateIndex(){
        //创建索引
        elasticsearchTemplate.createIndex(Article.class);

//创建映射
        elasticsearchTemplate.putMapping(Article.class);

    }
    //创建文档
    @org.junit.Test
    public void testCreateDouement(){
        Article article = new Article();
        article.setId(1L);
        article.setTitle("什么是Elasticsearch");
        article.setContent("ElasticSearch是一个基于Lucene的搜索服务器");
        //保存文档
        articleService.save(article);
    }
    //删除文档
    @org.junit.Test
    public void testDeleteDoc(){
        Article article = new Article();
        article.setId(1L);
        articleService.delete(article);
    }
//批量导入数据
    @org.junit.Test
    public void save100(){
        List<Article> articleList = new ArrayList<Article>();
        for (long i = 0; i < 100; i++) {
            Article article = new Article();
            article.setId(i);
            article.setTitle("什么是Elasticsearch" + i);
            article.setContent("ElasticSearch是一个基于Lucene的搜索服务器" + i);

            articleList.add(article);
        }
        articleService.save100(articleList);
    }
    //查询所有数据
    @org.junit.Test
    public void testFindAll(){
        Iterable<Article> all = articleService.findAll();
        for (Article article : all) {
            System.out.println(article);
        }
    }
    //分页查询数据
    @org.junit.Test
    public void testFindPage(){
        //设置分页参数：of(当前页0开始,每页查询条数,排序方式)
        PageRequest pageable = PageRequest.of(0, 20, new Sort(Sort.Direction.ASC, "id"));
        //分页查询
        Page<Article> page = articleService.findPage(pageable);

        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        for (Article article : page.getContent()) {
            System.out.println(article);
        }

    }
    @org.junit.Test
    public void testFindByContent(){
        //条件可以分词，支持通配符：*搜索*、搜索服务器
        List<Article> articleList = articleService.findByContent("*搜索*");
        for (Article article : articleList) {
            System.out.println(article);
        }
    }
    @org.junit.Test
    public void testFindByContentPage(){
        //条件可以分词，支持通配符：*搜索*、搜索服务器
        PageRequest pageable = PageRequest.of(0, 20);
        Page<Article> page = articleService.findByContent("搜索服务器", pageable);
        System.out.println("总页数：" + page.getTotalPages());
        System.out.println("总记录数：" + page.getTotalElements());
        for (Article article : page.getContent()) {
            System.out.println(article);
        }
    }

}
