package com.lcl.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.management.RuntimeMBeanException;
import javax.sql.DataSource;
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
    @Bean(name="runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier(value = "ds") DataSource dataSource){
        return new QueryRunner(dataSource);
    }
    @Bean(name = "ds")
    public DataSource createDataSource(){
        try {
            ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
            comboPooledDataSource.setJdbcUrl(url);
            comboPooledDataSource.setDriverClass(driver);
            comboPooledDataSource.setUser(username);
            comboPooledDataSource.setPassword(password);
            return comboPooledDataSource;
        } catch (Exception e) {
           throw new RuntimeException(e);
        }

    }
}
