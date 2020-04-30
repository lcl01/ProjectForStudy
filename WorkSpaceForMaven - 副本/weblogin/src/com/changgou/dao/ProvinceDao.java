package com.changgou.dao;

import com.changgou.bean.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDao {

    public List<Province> findAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(com.changgou.utils.C3P0Utils.getDataSource());
        String sql="select pid,pname from province";
        List<Province> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Province.class));
        return query;
    }
}
