package com.health.service;

import com.health.pojo.User;

public interface UserService {

    User findUserByUsername(String username);

}
