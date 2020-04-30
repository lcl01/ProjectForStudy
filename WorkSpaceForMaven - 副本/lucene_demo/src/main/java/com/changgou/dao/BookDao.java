package com.itheima.dao;

import com.itheima.bean.Book;

import java.util.List;

public interface BookDao {
    /**
     * 查询所有的book数据
     * @return
     */
    List<Book> queryBookList();
}
