package com.changgou.springboot_datajpa.controller;

import com.changgou.springboot_datajpa.bean.User;
import com.changgou.springboot_datajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("findAll")
    public List<User> findAll(){
        List<User> all = userService.findAll();
        return all;
    }
    @RequestMapping("findById/{id}")
    public User findById(@PathVariable Integer id){
        User byId = userService.findById(id);
        return byId;
    }
    @RequestMapping("save")
    public void save(User user){
        userService.save(user);
    }
    @RequestMapping("update")
    public void update(User user){
        userService.update(user);
    }

    @RequestMapping("deleteById/{id}")
    public void deleteById(@PathVariable Integer id){
        userService.deleteById(id);
    }
}
