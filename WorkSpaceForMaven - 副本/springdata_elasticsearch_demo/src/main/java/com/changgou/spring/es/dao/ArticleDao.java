package com.changgou.spring.es.dao;

import com.changgou.spring.es.bean.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleDao extends ElasticsearchRepository<Article,Long> {
    //根据内容查询
    List<Article> findByContent(String content);

    /**
     * 根据内容分页查询
     * @param content 内容
     * @param pageable 分页参数
     * @return 分页结果
     */
    Page<Article> findByContent(String content, Pageable pageable);
}
