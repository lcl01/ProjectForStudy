package com.health.application.controller;

import com.health.constant.MessageConstant;
import com.health.pojo.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getUsername")
    public Result getUsername()throws Exception{
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
             return new Result(true, MessageConstant.GET_USERNAME_SUCCESS,user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.GET_USERNAME_FAIL);
        }
    }
}
