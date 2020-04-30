package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.UserDao;
import com.itheima.ssm.domain.User;
import com.itheima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int saveUser(User user) {
        int saveUser = userDao.saveUser(user);
        return saveUser;
    }

    @Override
    public User findByNumberAndPassword(User user) {
        return userDao.findByNumberAndPassword(user.getNumber(),user.getPassword());
    }
}
