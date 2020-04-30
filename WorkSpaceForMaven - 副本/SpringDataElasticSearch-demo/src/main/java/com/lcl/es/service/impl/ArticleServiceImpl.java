package com.lcl.es.service.impl;

import com.lcl.es.dao.ArticleRepository;
import com.lcl.es.service.ArticleService;
import com.lcl.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    public void save(Article article) {
        articleRepository.save(article);
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }

    public Iterable <Article> findAll(Article article) {
        Iterable <Article> iter = articleRepository.findAll();
        return iter;
    }

    public List<Article> findByTitle(String condition) {
        return articleRepository.findByTitle(condition);
    }

    public Page <Article> findByTitle(String condition, Pageable pageable) {
        return articleRepository.findByTitle(condition,pageable);
    }

    public Iterable <Article> findAll() {
        Iterable<Article> iter = articleRepository.findAll();
        return iter;
    }

    public Page<Article> findAll(Pageable pageable){
        return articleRepository.findAll(pageable);
    }
}
