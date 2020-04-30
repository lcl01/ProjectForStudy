package com.changgou.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        e.printStackTrace();
        SysException se = null;
        // 获取到异常对象
        if(e instanceof SysException) {
            se = (SysException) e;
        }else {
            se = new SysException("请联系管理员");
        }
        ModelAndView mv = new ModelAndView();
        // 存入错误的提示信息
        mv.addObject("message", se.getMessage());
        // 跳转的Jsp页面
        mv.setViewName("error");// 跳转到WEB-INF/pages/error.jsp
        return mv;
    }
}
