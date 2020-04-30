package com.lcl.service.impl;

import com.lcl.dao.UserDao;
import com.lcl.pojo.User;
import com.lcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }
}
