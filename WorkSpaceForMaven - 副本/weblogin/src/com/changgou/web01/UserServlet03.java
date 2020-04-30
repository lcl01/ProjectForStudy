package com.changgou.web01;

import com.changgou.service.UserService01;
import com.itheima.bean.PageBean;
import com.changgou.bean.User01;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserServlet03",value = "/userServlet03")
public class UserServlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            String methodStr = req.getParameter("method");
            Class  clazz = this.getClass();
            //3. 根据方法名反射得到这个方法的Method对象  --判断是哪一个方法
            Method method = clazz.getDeclaredMethod(methodStr, HttpServletRequest.class, HttpServletResponse.class);
            //4.让这个方法执行
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void findAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        try {
            com.changgou.service.UserService01 userService01 = new com.changgou.service.UserService01();
            List<User01> list = (List<User01>) userService01.findAll();
            req.setAttribute("list",list);
            req.getRequestDispatcher("/list.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void add(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        try {
            Map<String, String[]> map = req.getParameterMap();
            User01 user01 = new User01();
            BeanUtils.populate(user01,map);
            com.changgou.service.UserService01 userService01 = new com.changgou.service.UserService01();
            userService01.addUser(user01);
            resp.sendRedirect("http://localhost:8080/userServlet03?method=findAll");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            //2. 调用业务
            com.changgou.service.UserService01 userService01 = new com.changgou.service.UserService01();
            userService01.deleteById(id);
            //3. 再查询所有展示
            resp.sendRedirect("http://localhost:8080/userServlet03?method=findAll");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg","服务器异常...");
            req.getRequestDispatcher("/msg.jsp").forward(req,resp);
        }
    }
    public void findByPage(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
        try {
            int curPage = Integer.parseInt(req.getParameter("curPage"));
            com.changgou.service.UserService01 userService01 = new UserService01();
            PageBean pageBean =  userService01.findByPage(curPage);


            //3.把pageBean存到request, 转发 list_page.jsp
            req.setAttribute("pageBean",pageBean);
            req.getRequestDispatcher("/list_page.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg","服务器异常...");
            req.getRequestDispatcher("/msg.jsp").forward(req,resp);
        }


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
