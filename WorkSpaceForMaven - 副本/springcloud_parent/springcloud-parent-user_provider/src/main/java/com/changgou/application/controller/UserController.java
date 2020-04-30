package com.itheima.application.controller;

import com.itheima.application.bean.User;
import com.itheima.application.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/find/{id}")
    public User findById(@PathVariable(value = "id") Integer id){
//        if (id==1) {
//            throw new RuntimeException("");
//        }
        User user = userService.findByUserId(id);
        user.setUsername(user.getUsername()+"  user-provider");
        return user;
    }
}
