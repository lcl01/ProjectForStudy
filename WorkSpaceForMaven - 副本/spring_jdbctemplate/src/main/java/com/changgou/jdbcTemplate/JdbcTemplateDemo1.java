package com.itheima.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/web28");
        ds.setUsername("root");
        ds.setPassword("199656");
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert into account(name,money)values('ccc',1000)");
//        jt.execute("delete from account where name ='ccc'");

    }
}
