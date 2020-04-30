package com.lcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello SpringMVC!");
        return "/WEB-INF/success.jsp";// 响应结果
    }
    @RequestMapping(path = "/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("hello SpringMvc!!!");
        return "/WEB-INF/success.jsp";
    }
    @RequestMapping(path = "/lcl",method = {RequestMethod.GET},params = {"username=haha"},headers = "accept")
    public String lcl(){
        System.out.println("lcl练习参数");
        return "/WEB-INF/success.jsp";
    }


}
