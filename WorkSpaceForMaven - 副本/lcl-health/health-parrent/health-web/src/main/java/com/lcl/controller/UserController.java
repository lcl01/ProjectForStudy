package com.lcl.controller;

import com.lcl.constant.MessageConstant;
import com.lcl.entity.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getUsername")
    public Result getUsername() throws Exception{
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println(user);
            return new Result(true, MessageConstant.GET_USERNAME_SUCCESS,user.getUsername());
        } catch (Exception e) {
            return new Result(false,MessageConstant.GET_USERNAME_FAIL);
        }

    }
}
