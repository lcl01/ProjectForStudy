package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign")
public class ConsumerFeignController {
    @Autowired
    private UserClient userClient;
    @RequestMapping("{id}")
    public User finById(@PathVariable(value = "id") Integer id){

        return userClient.findById(id);
    }

}
