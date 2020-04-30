package com.itheima.springboot_cloud.controller;

import com.itheima.springboot_cloud.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/list")
    public List<User> list(){
        ArrayList<User> user = new ArrayList<>();
        user.add(new User("张三", "深圳", 25));
        user.add(new User("李四", "北京", 26));
        user.add(new User("王五", "上海", 27));
        return user;
    }

}
