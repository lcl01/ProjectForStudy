package code;

import javax.sql.DataSource;
import java.sql.*;

public class MyJdbcTemplate {
    private DataSource dataSource;

    public MyJdbcTemplate() {
    }

    public MyJdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public int update(String sql, Object ... params){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //0. 非空判断
            if(dataSource == null){
                throw  new RuntimeException("dataSource must not null...");
            }

            if(sql == null){
                throw  new RuntimeException("sql must not null...");
            }

            //1. 从dataSource 获得连接对象
            connection = dataSource.getConnection();
            //2. 创建预编译的sql语句对象 insert into user values (?,?,?,?)
            preparedStatement = connection.prepareStatement(sql);

            //3. 获得参数的元数据对象
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
//            ResultSet resultSet = preparedStatement.executeQuery();
//            ResultSetMetaData metaData = resultSet.getMetaData();
//            int columnCount = metaData.getColumnCount();
//            String columnName = metaData.getColumnName(1);
//            int columnType = metaData.getColumnType(1);
            //4. 获得参数的个数
            int parameterCount = parameterMetaData.getParameterCount();
            //5. 给每一个?赋值
            for(int i = 0; i < parameterCount ;i++){
                preparedStatement.setObject(i+1,params[i]);
            }

            //6. 执行
            int i = preparedStatement.executeUpdate();
            return  i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            C3P0Utils.release(null,preparedStatement,connection);
        }


        return  -1;
    }
}
