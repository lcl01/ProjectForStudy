package com.changgou.dao;

import com.changgou.bean.User01;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao01 {

    public List<User01> findAll() throws Exception{
        JdbcTemplate jdbcTemplate = new JdbcTemplate(com.changgou.utils.C3P0Utils.getDataSource());
        List<User01> list = jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<>(User01.class));
        return list;
    }
    public void save(User01 user01)throws Exception{
        JdbcTemplate jdbcTemplate = new JdbcTemplate(com.changgou.utils.C3P0Utils.getDataSource());
        String sql="insert into user values(?,?,?,?,?,?,?)";
        Object[] param={null,user01.getName(),user01.getSex(),user01.getAge(),user01.getAddress(),user01.getQq(),user01.getEmail()};
        jdbcTemplate.update(sql,param);
    }
    public void delete(int id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(com.changgou.utils.C3P0Utils.getDataSource());
        String sql="delete from user where id= ?";
        jdbcTemplate.update(sql,id);
    }
    public int findCount(){
        return new JdbcTemplate(com.changgou.utils.C3P0Utils.getDataSource()).queryForObject("select count(*) from user",Long.class).intValue();
    }
    public List<User01> findLimit(int a,int b){
        return new JdbcTemplate(com.changgou.utils.C3P0Utils.getDataSource()).query("select * from user limit ?,?",new BeanPropertyRowMapper<>(User01.class),a,b);
    }
}
