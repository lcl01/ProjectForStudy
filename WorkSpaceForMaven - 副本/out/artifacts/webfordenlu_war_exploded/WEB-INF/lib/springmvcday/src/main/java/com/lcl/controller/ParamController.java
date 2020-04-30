package com.lcl.controller;

import com.lcl.domain.User;
import com.lcl.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
    @RequestMapping(path = "/param")
    public  class ParamController {
        @RequestMapping(path = "/testParam")
        public String lcl(String username,Integer age) {
            System.out.println("param:username:" +" "+ username + "age:" + age);
            return "/WEB-INF/success.jsp";
        }
        @RequestMapping(path = "/testParam1")
        public String testParam(User user){
            System.out.println("user:" + user);
            return "/WEB-INF/success.jsp";

        }
        @RequestMapping(path = "/saveAccount")
        public String testParam1(Account account){
            System.out.println(account);
            return "/WEB-INF/success.jsp";
        }
        @RequestMapping(path = "/saveUser")
        public String saveUser(User user){
            System.out.println(user);
            return "/WEB-INF/success.jsp";// 响应结果
        }
    @RequestMapping(path = "/testServlet")
        public String testServlet(HttpServletRequest request, HttpServletResponse response){
            System.out.println("request:"+request);
            System.out.println("session:"+request.getSession());
            System.out.println("application:"+request.getSession().getServletContext());
            System.out.println("response:"+response);
            return "/WEB-INF/success.jsp";// 响应结果
        }

    }

