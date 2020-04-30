package com.itheima.springboot_mysql.controller;

import com.itheima.springboot_mysql.bean.User;
import com.itheima.springboot_mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> all = service.findAll();
      return all;
    }
}
