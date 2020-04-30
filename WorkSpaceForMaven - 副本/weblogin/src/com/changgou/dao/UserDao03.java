package com.itheima.dao;

import com.itheima.bean.User02;
import com.changgou.utils.C3P0Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao03 {

    public User02 checkUserName(String username) {
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
            String sql="select * from user01 where username = ?";
            User02 user02=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User02.class),username);
            return user02;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
