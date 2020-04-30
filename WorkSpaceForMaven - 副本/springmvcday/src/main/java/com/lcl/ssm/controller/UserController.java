package com.lcl.ssm.controller;

import com.lcl.ssm.service.UserService;
import com.lcl.ssm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/save")
    public String save(User user){
        //增加
        int acount = userService.saveUser(user);

        if(acount>0){
            //新增成功，返回登录页面
            return "redirect:/login.html";
        }else{
            //新增失败，返回注册页面
            return "redirect:/register.html";
        }
    }
}
