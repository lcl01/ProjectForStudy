package com.itheima.service.impl;

import com.itheima.service.IUserService;

public class UserServiceImpl implements IUserService {
    @Override
    public boolean addUser() throws Exception {
        System.out.println("UserServiceImpl执行添加用户业务方法。。。");
        return true;
    }
}
