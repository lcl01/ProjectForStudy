package com.lcl.dao;

import com.lcl.pojo.User;

public interface UserDao {
    User findUserByUsername(String username);
}
