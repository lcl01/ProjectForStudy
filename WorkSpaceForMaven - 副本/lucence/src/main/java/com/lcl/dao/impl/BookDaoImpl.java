package com.lcl.dao.impl;



import com.lcl.dao.BookDao;
import com.lcl.pojo.Book;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> queryBookList() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        List <Book> list= new ArrayList <Book>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","199656");
            String sql="select * from book";
            preparedStatement= connection.prepareStatement(sql);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setPrice(resultSet.getFloat("price"));
                book.setPic(resultSet.getString("pic"));
                book.setDesc(resultSet.getString("desc"));
                list.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
