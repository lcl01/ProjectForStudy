import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web29","root","199656");
        PreparedStatement pstm = conn.prepareStatement("select * from account1");
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();
        pstm.close();
        conn.close();
    }
}
