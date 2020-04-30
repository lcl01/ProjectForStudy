package com.changgou.springboot_datajpa.service.impl;

import com.changgou.springboot_datajpa.bean.User;
import com.changgou.springboot_datajpa.dao.UserDao;
import com.changgou.springboot_datajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> user = userDao.findById(id);
        return user.get();
    }

    @Override
    public void save(User user) {
    userDao.save(user);
    }

    @Override
    public void update(User user) {
    userDao.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }
}
