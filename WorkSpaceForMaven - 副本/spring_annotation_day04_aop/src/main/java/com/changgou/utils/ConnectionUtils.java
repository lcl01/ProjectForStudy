package com.changgou.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

//import java.sql.Connection;
//import com.mysql.jdbc.Connection;

@Component
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public Connection getThreadConnection(){
        Connection conn = tl.get();
            //2.判断当前线程上是否有连接
            if (conn == null) {
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                try {
                    conn = dataSource.getConnection();
                    tl.set(conn);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        return conn;
    }
    public void removeConnection(){
        tl.remove();
    }
}
