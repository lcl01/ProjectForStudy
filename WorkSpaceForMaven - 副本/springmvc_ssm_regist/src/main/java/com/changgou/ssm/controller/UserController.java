package com.itheima.ssm.controller;

import com.itheima.ssm.domain.User;
import com.itheima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/save")
    public String save(User user){
        int acount=userService.saveUser(user);
        if (acount>0) {
            return "redirect:/login.html";
        }else {
            return "redirect:/register.html";

        }
    }
    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        User loginUser=userService.findByNumberAndPassword(user);
        if (loginUser!=null) {
            session.setAttribute("loginUser",loginUser);
            return "redirect:/index/welcome";

        }else {

            return"redirect:/login.html";
        }
    }

}
