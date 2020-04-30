package com.itheima.application.controller;

import com.changgou.application.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${name}")
    private String name;
    @Autowired
    @Qualifier("user")
    private User user;
    @RequestMapping("/hello")
    public String test(){
        return "哈哈name:"+name+",user:"+user;
    }
}
