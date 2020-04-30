package com.changgou.springboot_datajpa.service;

import com.changgou.springboot_datajpa.bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer id);

    void save(User user);

    void update(User user);

    void deleteById(Integer id);
}
