package com.itheima.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.*;
import com.itheima.service.impl.FavoriteService;
import com.itheima.service.impl.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/favorite")
public class FavoriteServlet extends BaseServlet {
    private FavoriteService favoriteService = new FavoriteService();
    private RouteService routeService = new RouteService();
    public void isFavorite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            String rid = req.getParameter("rid");
            User user = (User) req.getSession().getAttribute("user");
            if (user!=null) {
                boolean isFavorite =  favoriteService.isFavorite(user.getUid(),rid);
                map.put("isFavorite",isFavorite);
                resultInfo = new ResultInfo(true,map,"用户已经登录!");

            }else {
                map.put("isFavorite",true);
                resultInfo = new ResultInfo(true,map,"用户没有登录!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false,null,"服务器异常!");
        }finally {
            data=objectMapper.writeValueAsString(resultInfo);
            System.out.println("data=" + data);
            resp.getWriter().print(data);
        }
    }
    public void addFavorite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            String rid = req.getParameter("rid");
            User user = (User) req.getSession().getAttribute("user");
            if(user == null){
                map.put("isLogin",false);
                resultInfo = new ResultInfo(true,map,"用户没有登录!");
            }else{
                //3.登录了, 调用进行收藏业务
                favoriteService.addFavorite(user.getUid(),rid);
                //4.获得收藏次数
                int count = routeService.findByRid(rid).getCount();
                map.put("isLogin",true);
                map.put("count",count);
                resultInfo = new ResultInfo(true,map,"用户没有登录!");

            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false,null,"服务器异常!");
        }finally {
            data = objectMapper.writeValueAsString(resultInfo);
            System.out.println("data=" + data);
            resp.getWriter().print(data);
        }

    }
    public void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user  = (User) req.getSession().getAttribute("user");
            int uid = user.getUid();
            int curPage = Integer.parseInt(req.getParameter("curPage"));
            PageBean<Favorite> pageBean =    favoriteService.findByPage(uid,curPage);
            resultInfo = new ResultInfo(true,pageBean,"查询我的收藏成功!");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false,null,"查询我的收藏失败!");
        }finally {
            data=objectMapper.writeValueAsString(resultInfo);
            resp.getWriter().print(data);
        }
    }
    public void findRankByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        //1. 获得当前页码
        try {
            int curPage = Integer.parseInt(req.getParameter("curPage"));
            PageBean<Route> pageBean =  routeService.findFavoriteRank(curPage);
            resultInfo = new ResultInfo(true,pageBean,"收藏排行查询成功!");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false,null,"收藏排行查询失败!");
        }finally {
            data = objectMapper.writeValueAsString(resultInfo);
            System.out.println("data=" + data);
            resp.getWriter().print(data);
        }

    }
    public void findFavoriteRank(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            int curPage = Integer.parseInt(req.getParameter("curPage"));
            String rname = req.getParameter("rname");
            String startPrice = req.getParameter("startPrice");
            String endPrice = req.getParameter("endPrice");
            PageBean<Route> pageBean =  favoriteService.findFavoriteRank(curPage,rname,startPrice,endPrice);
            resultInfo = new ResultInfo(true,pageBean,"收藏排行查询成功!");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false,null,"收藏排行查询失败!");
        }finally {
            data=objectMapper.writeValueAsString(resultInfo);
            System.out.println("data=" + data);
            resp.getWriter().print(data);
        }
    }
}
