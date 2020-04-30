package com.itheima.ssm.service;

import com.itheima.ssm.domain.User;

public interface UserService {

    int saveUser(User user);

   public User findByNumberAndPassword(User user);
}
