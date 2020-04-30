package com.changgou.web01;

import com.changgou.service.Service.Service;
import com.changgou.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet01")
public class UserServlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            com.changgou.service.Service.Service service = new Service();
            User user=service.login(username,password);
            if (user!=null) {
                resp.getWriter().print("login success");
            }else {
                resp.getWriter().print("login failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("login failed");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
