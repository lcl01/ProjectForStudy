package com.changgou.web;

import com.changgou.bean.User;
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

            //2. 使用JDBCTemplate根据用户名和密码查询数据库
            //a. 创建JDBCTemplate对象
            JdbcTemplate jdbcTemplate = new JdbcTemplate(com.changgou.utils.C3P0Utils.getDataSource());
            //b. 编写sql语句, 执行
            String sql = "SELECT * FROM t_user WHERE username = ? AND password = ?";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);

            //3. 判断是否为null
            if(user != null){
                resp.getWriter().print("Login Success");
            }else{
                resp.getWriter().print("Login Failed");
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
