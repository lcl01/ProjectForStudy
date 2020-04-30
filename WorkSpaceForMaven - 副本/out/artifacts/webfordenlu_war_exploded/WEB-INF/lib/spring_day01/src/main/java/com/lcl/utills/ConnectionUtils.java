package com.lcl.utills;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectionUtils {
    private ThreadLocal <java.sql.Connection> tl=new ThreadLocal <java.sql.Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public java.sql.Connection getThreadConnection(){
        try {
            Connection connection = tl.get();
            if(connection==null){
                connection =dataSource.getConnection();
                tl.set(connection);
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void removeConnection(){
        tl.remove();
    }
}
