package com.lcl.config;

import com.lcl.utills.ConnectionUtils;
import com.lcl.utills.TransactionManager;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//@Configuration
@ComponentScan(value = {"com.lcl"})
@Import(value = JdbcConfig.class)
//@Import(value = TransactionManager.class)
//@Import(value = ConnectionUtils.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {
//    @Bean(name = "runner")
//    @Scope("prototype")
//    public QueryRunner createQueryRunner(DataSource dataSource) {
//        return new QueryRunner(dataSource);
//    }
//
//    @Bean(name = "ds")
//    public DataSource createDataSource() {
//        try {
//            ComboPooledDataSource ds = new ComboPooledDataSource();
//            ds.setDriverClass("com.mysql.jdbc.Driver");
//            ds.setJdbcUrl("jdbc:mysql://localhost:3306/web29");
//            ds.setUser("root");
//            ds.setPassword("199656");
//            return ds;
//        } catch (Exception e) {
//           throw new RuntimeException(e);
//        }
//    }
}


