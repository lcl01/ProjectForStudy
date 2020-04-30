package com.lcl.ssm.service.impl;

import com.lcl.ssm.dao.UserDao;
import com.lcl.ssm.domain.User;
import com.lcl.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    public int saveUser(User user) {
        return userDao.save(user);
    }
    public User findByNumberAndPassword(User user) {
        return userDao.findByNumberAndPassword(user);
    }
}
