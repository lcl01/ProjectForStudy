package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/base")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String methodStr =  req.getParameter("method");
            //2.获得字节码
            Class clazz =  this.getClass();
            //3. 根据methodStr(方法名) 方式得到Method对象
            Method method =  clazz.getMethod(methodStr,HttpServletRequest.class,HttpServletResponse.class);
            method.setAccessible(true);
//            4.让方法执行
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
