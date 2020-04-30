package com.itheima.application.sevice.impl;

import com.itheima.application.dao.UserDao;
import com.itheima.application.bean.User;
import com.itheima.application.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findByUserId(Integer id) {
        return userDao.findById(id).get();
    }
}
