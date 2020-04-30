package com.changgou.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.beans.PropertyVetoException;

public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    @Bean("runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier(value = "ds2") ComboPooledDataSource dataSource){
        return new QueryRunner(dataSource);
    }
    @Bean("ds")
    public ComboPooledDataSource createDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
//            ds.setDriverClass("com.mysql.jdbc.Driver");
//            ds.setJdbcUrl("jdbc:mysql://localhost:3306/itcastspring");
//            ds.setUser("root");
//            ds.setPassword("root");
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);

            return ds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }
    @Bean("ds2")
    public ComboPooledDataSource createDataSource2(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
//            ds.setDriverClass("com.mysql.jdbc.Driver");
//            ds.setJdbcUrl("jdbc:mysql://localhost:3306/itcastspring");
//            ds.setUser("root");
//            ds.setPassword("root");
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);

            return ds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }
}
