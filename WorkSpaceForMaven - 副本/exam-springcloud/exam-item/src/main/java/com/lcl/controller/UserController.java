package com.lcl.controller;

import com.lcl.domain.User;
import com.lcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /***
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @RequestMapping("/find/{id}")
    public User findById(@PathVariable(value = "id") Integer id){
        User user = userService.findByUserId(id);
        user.setUsername(user+"user-provider-demo1");
        return user;
    }
}
