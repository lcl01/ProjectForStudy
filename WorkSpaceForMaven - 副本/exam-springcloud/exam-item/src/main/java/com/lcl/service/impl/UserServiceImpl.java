package com.lcl.service.impl;

import com.lcl.dao.UserDao;
import com.lcl.domain.User;
import com.lcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findByUserId(Integer id) {
        return userDao.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
