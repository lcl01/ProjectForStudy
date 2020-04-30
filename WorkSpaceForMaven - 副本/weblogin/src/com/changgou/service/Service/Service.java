package com.changgou.service.Service;

import com.changgou.bean.User;
import com.changgou.dao.Dao.UserDao;

public class Service {

    public User login(String username, String password) {
        UserDao userDao = new UserDao();
        User user = userDao.findByUnameAndPwd(username, password);
        return user;
    }
}
