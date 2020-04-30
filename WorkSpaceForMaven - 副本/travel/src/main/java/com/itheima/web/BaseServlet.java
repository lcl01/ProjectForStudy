package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/web")
public class BaseServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String methodStr = req.getParameter("method");
             Class  clazz = this.getClass();
            Method method = clazz.getMethod(methodStr, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
