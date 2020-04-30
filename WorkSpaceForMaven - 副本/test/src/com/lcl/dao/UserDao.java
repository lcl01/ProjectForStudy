package com.lcl.dao;

import code.C3P0Utils;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public int save(String username, String password, String nickname){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
        String sql="insert into user values(?,?,?,?)";
        Object[] params=new Object[]{null,username,password,nickname};
        int update = jdbcTemplate.update(sql, params);
        return update;
    }
}
