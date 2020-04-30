package com.lcl.es.service;

import com.lcl.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {
    public void save(Article article);
    //删除
    public void delete(Article article);
    public Iterable<Article> findAll(Article article);
    public Page<Article> findAll(Pageable pageable);
    List<Article> findByTitle(String condition);
    //根据标题查询(含分页)
    Page<Article> findByTitle(String condition, Pageable pageable);

    Iterable<Article> findAll();

}
