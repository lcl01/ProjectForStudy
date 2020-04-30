package com.lcl.service;

import com.lcl.domain.User;

import java.util.List;


public interface UserService {
    User findByUserId(Integer id);
    List<User> findAll();
}
