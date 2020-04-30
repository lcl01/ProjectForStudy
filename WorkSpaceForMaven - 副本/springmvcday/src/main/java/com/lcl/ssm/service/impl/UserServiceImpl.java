package com.lcl.ssm.service.impl;

import com.lcl.ssm.dao.UserDao;
import com.lcl.ssm.domain.User;
import com.lcl.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public int saveUser(User user) {
        return userDao.save(user);
    }
}
