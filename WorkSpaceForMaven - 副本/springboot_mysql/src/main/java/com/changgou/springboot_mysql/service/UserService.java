package com.itheima.springboot_mysql.service;

import com.itheima.springboot_mysql.bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
