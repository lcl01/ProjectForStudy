package code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginClient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();
        Connection connection = JdbcDemo.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        while (resultSet.next()) {
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("nickname")
            );
        }
        // 3. 判断是否登录成功(说白了就是判断User对象是为null)
        if (user != null) {
            //  user不为null, 给用户提示 登录成功
            System.out.println("登录成功!尊敬的" + user.getNickname());
        } else {
            // user为null, 给用户提示 登录失败
            System.err.println("登录失败");
        }

        //4. 释放资源
        JdbcDemo.release(resultSet,statement,connection);

    }
}
