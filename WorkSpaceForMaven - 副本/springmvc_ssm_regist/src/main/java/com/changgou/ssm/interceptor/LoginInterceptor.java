package com.changgou.ssm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser==null) {
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;
        }
        return true;
    }
}
