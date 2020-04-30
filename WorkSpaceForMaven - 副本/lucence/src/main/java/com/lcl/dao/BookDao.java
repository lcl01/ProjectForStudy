package com.lcl.dao;


import com.lcl.pojo.Book;

import java.util.List;

public interface BookDao {
    List<Book> queryBookList();
}
