package com.itheima.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.ResultInfo;
import com.itheima.bean.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.service.impl.Userservice;
import com.itheima.utils.FactoryUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
//    private IUserService userServiceItf = new UserServiceImpl();
private IUserService userServiceItf1 = (IUserService) FactoryUtil.getImplObject("IUserService");
    private Userservice userService = new Userservice();
    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
//            String[] parameterValues = req.getParameterValues(data);
            Map<String, String[]> map = req.getParameterMap( );
            User user = new User();
            BeanUtils.populate(user,map);

            userService.regist(user);
            resultInfo=new ResultInfo(true,null,"注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"注册失败");
        }finally {
            data=objectMapper.writeValueAsString(resultInfo);
            resp.getWriter().print(data);
        }

    }
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = userService.login(username, password);
            if(user != null){
                if("Y".equals(user.getStatus())){
                    //登录成功
                    req.getSession().setAttribute("user",user);
                    resultInfo = new ResultInfo(true,null,"登录成功...");
                }else{
                    resultInfo = new ResultInfo(false,null,"您还没有激活...");
                }

            }else {
                resultInfo = new ResultInfo(false,null,"用户名和密码不一致...");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false,null,"服务器异常,登录失败...");
        }finally {
            data = objectMapper.writeValueAsString(resultInfo);
            resp.getWriter().print(data);
        }


    }
    public void active(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //1.获得激活码
            String code = req.getParameter("code");
            boolean isActive = userService.active(code);
            if(isActive){
                resp.sendRedirect(req.getContextPath()+"/login.html");
            }else{
                resp.getWriter().print("<h1>激活失败</h1>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().print("<h1>激活失败</h1>");
        }

    }


    public void getLoginInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        User user  = (User) req.getSession().getAttribute("user");
        if(user != null){
            //是登录状态
            resultInfo = new ResultInfo(true,user,"已经登录");
        }else{
            //不是登录状态
            resultInfo = new ResultInfo(false,null,"未登录");
        }
        data =  objectMapper.writeValueAsString(resultInfo);
        System.out.println("data="+data);
        resp.getWriter().print(data);
    }
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getSession().removeAttribute("user");
        resp.sendRedirect(req.getContextPath()+"/login.html");
    }
    public void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try {
            userServiceItf1.addUser();//调用业务方法
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
