package com.lcl.controller;

import com.lcl.domain.User;
import com.lcl.service.UserService;
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
    @RequestMapping("/findUsers")
    public List<User> findUsers(){
        return userService.findUsers();
    }
    @RequestMapping("//findUserById/{id}")
    public User findUserById(@PathVariable Integer id){
        return userService.findUserById(id);
    }
    @RequestMapping("/updateUser")
    public void updateUser(User user){
        userService.updateUser(user);
    }

    @RequestMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
    }
}
