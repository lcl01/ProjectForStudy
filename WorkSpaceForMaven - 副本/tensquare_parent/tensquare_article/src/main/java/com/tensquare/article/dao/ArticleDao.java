package com.tensquare.article.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tensquare.article.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface ArticleDao extends BaseMapper<Article> {
}
