package com.itheima.application.sevice;

import com.itheima.application.bean.User;

public interface UserService {
    public User findByUserId(Integer id);
}
