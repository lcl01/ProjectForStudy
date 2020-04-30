package com.itheima.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcService {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web29", "root", "199656");
        PreparedStatement preparedStatement = conn.prepareStatement("select * from account01");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name")+resultSet.getString("money"));

        }
        resultSet.close();
        preparedStatement.close();
        conn.close();
    }
}
