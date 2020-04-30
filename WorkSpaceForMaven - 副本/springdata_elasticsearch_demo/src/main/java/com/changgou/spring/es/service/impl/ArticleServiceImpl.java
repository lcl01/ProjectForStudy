package com.changgou.spring.es.service.impl;

import com.changgou.spring.es.bean.Article;
import com.changgou.spring.es.dao.ArticleDao;
import com.changgou.spring.es.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    public void save(Article article) {
        articleDao.save(article);
    }

    public void delete(Article article) {
        articleDao.delete(article);
    }

    public void save100(List<Article> articleList) {
        articleDao.saveAll(articleList);
    }

    public Iterable<Article> findAll() {
        return articleDao.findAll();
    }

    public Page<Article> findPage(Pageable pageable) {
        return articleDao.findAll(pageable);
    }

    public List<Article> findByContent(String content) {
        return articleDao.findByContent(content);
    }

    public Page<Article> findByContent(String content, Pageable pageable) {
        return articleDao.findByContent(content,pageable);
    }
}
