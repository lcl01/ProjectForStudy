package com.itheima.dao;

import com.itheima.bean.User;
import com.itheima.utils.C3P0Util;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Util.getDataSource());
    public void save(User user) {
        String sql="insert into tab_user values(null,?,?,?,?,?,?,?,?,?)";
        String[] params={
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode()};
        jdbcTemplate.update(sql,params);

    }

    public int active(String code) {
        String sql="update tab_user set status=?  where code=?";
        int y = jdbcTemplate.update(sql, "Y", code);
        return y;

    }
    public User login(String username, String password) {
        String sql="select * from tab_user where username=? and password=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper <>(User.class), username, password);

        return user;
    }
}
