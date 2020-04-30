package com.lcl.ssm.controller;

import com.lcl.ssm.domain.User;
import com.lcl.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    /***
     * 增加用户
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public String save(User user) {
        //增加
        int acount = userService.saveUser(user);
        System.out.println("11");
        if (acount > 0) {
            //新增成功，返回登录页面
            return "redirect:/login.html";
        } else {
            //新增失败，返回注册页面
            return "redirect:/register.html";
        }
    }

    @RequestMapping(value = "/login")
    public String login(User user, HttpSession session) {
        //数据库查询登录
        User loginUser = userService.findByNumberAndPassword(user);

        //判断loginUser是否为空
        if (loginUser != null) {
            //登录成功跳转到欢迎页
            session.setAttribute("loginUser", user);
            return "redirect:/index/welcome";
        } else {
            //为空，登录失败，继续登录
            return "redirect:/login.html";
        }
    }
}