package com.changgou.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/ServletDemo03")
public class ServletDemo03 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String method = request.getMethod();
        if("post".equalsIgnoreCase(method)){
            //2.如果是,处理乱码
            request.setCharacterEncoding("utf-8");
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
