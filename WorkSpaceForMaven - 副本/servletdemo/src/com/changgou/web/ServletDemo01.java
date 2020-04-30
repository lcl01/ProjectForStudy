package com.itheima.web;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo01 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化：" + servletConfig.getInitParameter("akey"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello");
        servletResponse.getWriter().print("hello");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
