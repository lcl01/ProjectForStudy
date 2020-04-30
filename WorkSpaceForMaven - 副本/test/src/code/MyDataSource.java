package code;

import java.sql.Connection;
import java.util.LinkedList;

public class MyDataSource {
    private static LinkedList<Connection> pool;
    static{
        try {
            pool=new LinkedList<Connection>();
            for (int i = 0; i < 5; i++) {
                Connection connection = JdbcDemo.getConnection();
                pool.add(connection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int getCount(){
        return pool.size();
    }
    public Connection getConnection(){
        return pool.removeFirst();
    }
    public void addBack(Connection connection){
        pool.addLast(connection);

    }
}
