package com.health.dao;

import com.health.pojo.User;

public interface UserDao {
    public User findUserByUsername(String username);

}
