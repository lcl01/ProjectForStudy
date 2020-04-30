package com.itheima.web;

import com.changgou.bean.User;
import com.changgou.service.Service.Service;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet02")
public class UserServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html;charset=utf-8");
            String userCode = req.getParameter("code");
            String formCode =(String) req.getSession().getAttribute("code");
            if (!formCode.equalsIgnoreCase(userCode)) {
                resp.getWriter().print("验证码不一致,请重新输入....");
            }
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            Service userService = new Service();
            User user = userService.login(username, password);
            if(user != null){
                resp.getWriter().print("Login Success");
            }else{
                resp.getWriter().print("Login Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("Login Failed");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
