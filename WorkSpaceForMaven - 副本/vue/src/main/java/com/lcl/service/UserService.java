package com.lcl.service;

import com.lcl.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(Integer id);

   int update(User user);
}
