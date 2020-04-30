package com.itheima.web;

import com.itheima.service.UserService03;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/servletAjaxDemo02")
public class ServletAjaxDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserService03 userService03 = new UserService03();
        boolean isExit=userService03.checkUserName(username);
//        if (isExit) {
//            resp.getWriter().print(false);
//        }else {
//            resp.getWriter().print(true);
//        }
        resp.getWriter().print(!isExit);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
