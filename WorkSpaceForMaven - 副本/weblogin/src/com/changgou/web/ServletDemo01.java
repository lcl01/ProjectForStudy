package com.changgou.web;

import com.changgou.utils.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                if ("akey".equals(cookie.getName())) {
                    System.out.println(cookie.getValue());
                }
                System.out.println(cookie.getName() + "=" + cookie.getValue());
            }
        }
        Cookie acookie = new Cookie("akey", "aaa");
        Cookie bcookie = new Cookie("bkey", "bbb");
        resp.addCookie(acookie);
        resp.addCookie(bcookie);
        resp.getWriter().print("ServletDemo01");
        System.out.println(CookieUtil.getTargetCookie("akey", req.getCookies()).getValue());



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
