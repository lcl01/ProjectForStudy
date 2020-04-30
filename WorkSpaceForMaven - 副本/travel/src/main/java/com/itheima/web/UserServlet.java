package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.ResultInfo;
import com.itheima.bean.User;
import com.itheima.service.UserService;
import com.itheima.utils.MailUtil;
import com.itheima.utils.Md5Util;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends BaseServlet  {
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=null;
        ResultInfo resultInfo=null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map <String, String[]> map = req.getParameterMap();
        User user = new User();

            BeanUtils.populate(user,map);
            UserService userService = new UserService();
            userService.regist(user);
            resultInfo = new ResultInfo(true, null, "注册成功");

        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "注册失败");

        } finally {
            data=objectMapper.writeValueAsString(resultInfo);
            resp.getWriter().print(data);
        }
    }

    public void active(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String code = req.getParameter("code");
            UserService userService = new UserService();
            Boolean isActive= userService.active(code);
            if(isActive){
                resp.sendRedirect(req.getContextPath()+"/login.html");

            }else {
                resp.getWriter().print("<h1>激活失败</h1>");
            }
        } catch (IOException e) {
            e.printStackTrace();
            resp.getWriter().print("<h1>激活失败</h1>");
        }


    }
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=null;
        ResultInfo resultInfo=null;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String username=req.getParameter("username");
            String password=req.getParameter("password");
            UserService userService = new UserService();
            User user=userService.login(username,password);
            if(user!=null) {
                if ("Y".equals(user.getStatus())) {
                    req.getSession().setAttribute("user", user);
                    resultInfo = new ResultInfo(true, null, "登入成功");

                } else {
                    resultInfo = new ResultInfo(false, null, "登入失败，用户名还未激活");
                }
            }else {

                resultInfo = new ResultInfo(false, null, "用户名和密码不一致");

            }
        } catch (Exception e) {
            e.printStackTrace();
           resultInfo= new ResultInfo(false, null, "服务器异常");
        }finally {
            data=objectMapper.writeValueAsString(resultInfo);
            resp.getWriter().print(data);
        }

    }
    public void getLoginInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=null;
        ResultInfo resultInfo =null;
        ObjectMapper objectMapper = new ObjectMapper();
        User user =(User) req.getSession().getAttribute("user");
        if(user!=null){
            resultInfo = new ResultInfo(true, user, "已登录");
        }else{
            resultInfo = new ResultInfo(false, null, "未登录");

        }
       data= objectMapper.writeValueAsString(resultInfo);
        System.out.println(data);
        resp.getWriter().print(data);
    }
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        resp.sendRedirect(req.getContextPath()+"/login.html");
    }
}
