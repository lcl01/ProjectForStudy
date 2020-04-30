package code;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Utils {
    private static DataSource dataSource=new ComboPooledDataSource();

    public static DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static Connection getConnection() throws Exception {
        Connection connection = dataSource.getConnection();
        return  connection;
    }
    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();//看Connection来自哪里, 如果Connection是从连接池里面获得的, close()方法其实是归还; 如果Connection是创建的, 就是销毁
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
