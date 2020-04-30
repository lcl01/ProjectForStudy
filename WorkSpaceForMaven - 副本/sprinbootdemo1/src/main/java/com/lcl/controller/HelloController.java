package com.lcl.controller;

import com.lcl.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/insert")
public class HelloController {
    @RequestMapping("/hhhh")
    public String hello(){
        return "fwdfsgfsfdg";
    }
    @RequestMapping("/data")
    public List<User> data(){
        List <User> users = new ArrayList <>();
        users.add(new User("lc","湖南",20));
        users.add(new User("lc","湖南",21));
        users.add(new User("lc","湖南",22));

        return users;
    }
}
