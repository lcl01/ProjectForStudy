package com.changgou.web;

import com.changgou.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/RememberServlet")
public class RememberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        Cookie targetCookie = CookieUtil.getTargetCookie("lastTime", cookies);
        if (targetCookie==null) {
            Cookie cookie = new Cookie("lastTime", System.currentTimeMillis() + "");
            cookie.setMaxAge(60*60*24); //设置存活时间
            cookie.setPath(req.getContextPath()); //设置有效路径
            resp.addCookie(cookie);
            resp.getWriter().print("你是第一次访问!");
        }else{
            Cookie cookie = new Cookie("lastTime", System.currentTimeMillis() + "");
            cookie.setMaxAge(60*60*24);
            cookie.setPath(req.getContextPath());
            resp.addCookie(cookie);
            String timerStr = targetCookie.getValue();
            long time = Long.parseLong(timerStr);
            resp.getWriter().print("上次"+new Date(time).toLocaleString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
