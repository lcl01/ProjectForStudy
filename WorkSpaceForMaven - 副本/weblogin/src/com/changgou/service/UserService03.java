package com.itheima.service;

import com.itheima.bean.User02;
import com.itheima.dao.UserDao03;

public class UserService03 {
    public boolean checkUserName(String username) {
        UserDao03 userDao03 = new UserDao03();
        User02 user02=userDao03.checkUserName(username);
        if (user02 !=null){
            return true;
        }else {
            return false;
        }
    }
}
