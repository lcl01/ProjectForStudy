package com.lcl.service;

import com.lcl.dao.UserDao;

public class UserService {
    public Boolean regist(String username, String password, String nickname){
        UserDao userDao = new UserDao();
        int i = userDao.save(username, password, nickname);
        return i>0;
    }
}
