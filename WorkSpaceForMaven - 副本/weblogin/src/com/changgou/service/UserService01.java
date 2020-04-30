package com.changgou.service;

import com.itheima.bean.Constants;
import com.itheima.bean.PageBean;
import com.changgou.bean.User01;
import com.changgou.dao.UserDao01;


import java.util.List;

public class UserService01 {
    public List<User01> findAll() throws Exception {
        UserDao01 userDao01 = new UserDao01();

        return (List<User01>) userDao01.findAll();
    }

    public void addUser(User01 user01) throws Exception {
        UserDao01 userDao01 = new UserDao01();
        userDao01.save(user01);
    }

    public void deleteById(int id) {
        UserDao01 userDao01 = new UserDao01();
        userDao01.delete(id);
    }

    public PageBean findByPage(int curPage) {
        UserDao01 userDao01 = new UserDao01();
        int curSize = Constants.size;
        int count=userDao01.findCount();
        int sumPage=0;
        if (count%curSize==0) {
            sumPage=count/curSize;
        }else {
            sumPage=count/curPage+1;
        }
        int b=curSize;
        int a=(curPage-1)*b;
        List<User01> list=userDao01.findLimit(a,b);
        PageBean pageBean = new PageBean(list,curPage,sumPage,count,curSize);

        return pageBean;
    }
}
