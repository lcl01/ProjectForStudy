package com.changgou.spring.es.service;

import com.changgou.spring.es.bean.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {
    public void save(Article article);
    //删除文档
    public void delete(Article article);
    //批量导入数据
    public void save100(List<Article> articleList);
    //查询全部
    public Iterable<Article> findAll();
    //分页查询
    public Page<Article> findPage(Pageable pageable);
    //根据内容查询
    List<Article> findByContent(String content);
    /**
     * 根据内容分页查询
     * @param content 内容
     * @param pageable 分页参数
     * @return 分页结果
     */
    Page<Article> findByContent(String content,Pageable pageable);
}
