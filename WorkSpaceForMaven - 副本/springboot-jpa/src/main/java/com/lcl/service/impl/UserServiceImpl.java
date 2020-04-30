package com.lcl.service.impl;

import com.lcl.dao.UserDao;
import com.lcl.domain.User;
import com.lcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findUsers() {
        return userDao.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        Optional <User> optional = userDao.findById(id);
        return optional.get() ;
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteById(id);
    }
}
