package com.lcl.ssm.intercepter;

import com.lcl.ssm.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName SessionIntercepter
 * @Description TODO
 * @Author ly
 * @Company 深圳黑马程序员
 * @Date 2019/6/6 12:08
 * @Version V1.0
 */

// 拦截器配置，第一步：定义拦截器
public class SessionIntercepter implements HandlerInterceptor {

    // 在访问Controller类之前
    /**
     * * 获取当前Session
     如果Session有值，已经登录，放行
     如果Session没有值，没有登录，不能放行，重定向到登录页面...
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute("user");
        // 如果Session没有值，没有登录，不能放行，重定向到登录页面...
        if(user==null){
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false; // 不放行
        }
        return true;
    }
}


