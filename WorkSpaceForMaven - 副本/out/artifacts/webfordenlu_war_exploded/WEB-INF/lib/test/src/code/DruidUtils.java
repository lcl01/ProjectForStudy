package code;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DruidUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static DataSource dataSource;
    static {
        Properties properties = new Properties();
// 关联druid.properties文件
        try {

            InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
//1. 创建DataSource


//2. 从数据源(连接池)获得连接对象

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {


        return dataSource.getConnection();
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
