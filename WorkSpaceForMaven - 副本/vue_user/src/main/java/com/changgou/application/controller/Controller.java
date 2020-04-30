package com.changgou.application.controller;

import com.changgou.pojo.Result;
import com.changgou.pojo.User;
import com.changgou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public List<User> findAll(){

            List<User> userList = userService.findAll();
            System.out.println(userList);
            return userList;

    }
    @RequestMapping("/findOne/{id}")
    public Result findOne(@PathVariable("id") Integer id){
        try {
            User user = userService.findOne(id);
            return new Result(false,user,"null");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,null,"服务器异常");
        }
    }
    @RequestMapping("/update")
    public Result update(@RequestBody User user){
        try {
            userService.update(user);
            return new Result(true,null,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,null,"服务器异常");
        }
    }

}
