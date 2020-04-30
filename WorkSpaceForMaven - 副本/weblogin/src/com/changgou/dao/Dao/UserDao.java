package com.changgou.dao.Dao;

import com.changgou.bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    public User findByUnameAndPwd(String username, String password) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(com.changgou.utils.C3P0Utils.getDataSource());
        String sql="select id,username,password from t_user where username=? and password=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
        return user;
    }
}
