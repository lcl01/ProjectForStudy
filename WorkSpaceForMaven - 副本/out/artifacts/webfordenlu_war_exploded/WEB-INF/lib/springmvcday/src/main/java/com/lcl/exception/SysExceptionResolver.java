package com.lcl.exception;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver extends Throwable implements HandlerExceptionResolver {
    @Nullable
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Nullable Object o, Exception e) {
        e.printStackTrace();
        SysException se=null;
        if (e instanceof SysException) {
            se=(SysException) e;
        }else {
            se = new SysException("请联系lcl");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",se.getMessage());
        modelAndView.setViewName("error");
        return  modelAndView;
    }
}
