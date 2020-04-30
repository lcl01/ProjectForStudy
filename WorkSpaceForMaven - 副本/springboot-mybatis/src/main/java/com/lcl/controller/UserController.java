package com.lcl.controller;

import com.lcl.domain.User;

import java.util.List;
import com.lcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
    @RequestMapping("/hello")
    public String hellp(){
        return "dfsdgfsg";
    };
}
