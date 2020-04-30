package com.lcl.controller;

import com.lcl.pojo.User;
import com.lcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAll();
    }
    @RequestMapping("/findOne")
    @ResponseBody
    public User findOne(Integer id){
        return userService.findOne(id);
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(@RequestBody User user){
        if(userService.update(user) > 0){
            return true;
        }else{
            return false;
        }
    }
}
