package com.itheima.dao;

import com.itheima.bean.Category;
import com.itheima.utils.C3P0Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDao {
private JdbcTemplate jdbcTemplate=new JdbcTemplate(C3P0Utils.getDataSource());
    public List<Category> findAll() {
        String sql="select * from tab_category";
        List<Category> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Category.class));
        return list;
    }
}
