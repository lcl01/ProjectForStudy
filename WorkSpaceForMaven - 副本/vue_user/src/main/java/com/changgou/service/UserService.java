package com.changgou.service;

import com.changgou.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findOne(int id);

    public void update(User user);
}
