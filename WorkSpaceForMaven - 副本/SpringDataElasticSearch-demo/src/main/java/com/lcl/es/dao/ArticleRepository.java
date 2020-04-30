package com.lcl.es.dao;

import com.lcl.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepository extends ElasticsearchRepository<Article,Integer> {
    //根据标题查询
    List<Article> findByTitle(String condition);

    //根据标题查询(含分页)
    Page<Article> findByTitle(String condition, Pageable pageable);
}
