package com.itheima.service;

import com.itheima.domain.User;

public interface UserService {
    User findByUserId(Integer id);
}
