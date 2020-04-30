package com.itheima.web;

import com.itheima.bean.User1;
import com.itheima.utils.C3P0Utils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
            String sql="SELECT id,username,password FROM t_user WHERE username = ? AND password = ?";
            User1 user1 =jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User1.class),username,password);
            if (user1==null) {
                resp.getWriter().print("Login success");
            }else {
                resp.getWriter().print("login Failed");
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
