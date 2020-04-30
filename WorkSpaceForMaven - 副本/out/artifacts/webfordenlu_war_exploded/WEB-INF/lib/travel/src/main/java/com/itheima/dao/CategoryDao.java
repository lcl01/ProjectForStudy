package com.itheima.dao;

import com.itheima.bean.Category;
import com.itheima.utils.C3P0Util;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Util.getDataSource());
    public List <Category> finAll() {
        String sql="select * from tab_category order by cid  ASC ";
        return  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Category.class));
    }
}
