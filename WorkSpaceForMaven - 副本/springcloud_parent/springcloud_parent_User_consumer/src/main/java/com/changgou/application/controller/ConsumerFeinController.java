package com.itheima.application.controller;

import com.itheima.application.domain.User;
import com.itheima.application.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("feign")
public class ConsumerFeinController {
    @Autowired
    private UserClient userClient;
    @RequestMapping("{id}")
    public User findById(@PathVariable(value = "id") Integer id){
        return userClient.findById(id);
    }
}
