package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/filterDemo01")
public class FilterDemo01 implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo01收到了请求...");
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("int()>>>>" + config.getInitParameter("akey"));
    }

}
