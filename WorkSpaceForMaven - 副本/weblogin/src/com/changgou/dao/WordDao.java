package com.itheima.dao;

import com.itheima.bean.Words;
import com.changgou.utils.C3P0Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class WordDao {

    public List<Words> findByKeyWord(String keyword) throws Exception{
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
        String sql = "SELECT * FROM words WHERE word like ? LIMIT ?,?";
        List<Words> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Words.class), "%" + keyword + "%", 0, 5);
        return query;
    }
}
