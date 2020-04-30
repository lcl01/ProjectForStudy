package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.*;
import com.itheima.service.FavoriteService;
import com.itheima.service.RoutService;
import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/favorite")
public class FavoriteServlet extends BaseServlet {
    private  FavoriteService favoriteService=new FavoriteService();
    private RoutService routService=new RoutService();

    public void findFavoriteRank(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=null;
        ResultInfo resultInfo=null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            int curPage =Integer.parseInt( req.getParameter("curPage"));
            String rname = req.getParameter("rname");
            System.out.println("rname数据="+rname);
            String startPrice = req.getParameter("startPrice");
            System.out.println("startPrice" + startPrice);
            String endPrice = req.getParameter("endPrice");

            PageBean<Route> pageBean=routService.findFavoriteRank(curPage,rname,startPrice,endPrice);
            resultInfo = new ResultInfo(true, pageBean, "得到收藏排行榜");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(true, null, "没有得到收藏排行榜");

        }finally {
            data=objectMapper.writeValueAsString(resultInfo);
            System.out.println("排行数据=" + data);
            resp.getWriter().print(data);
        }
    }

    public void findByPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String data=null;
        ResultInfo resultInfo=null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user=(User)req.getSession().getAttribute("user");
            int uid = user.getUid();
            String curPage1 = req.getParameter("curPage");
            int curPage = Integer.parseInt(curPage1);
            System.out.println("curPage="+curPage);
            PageBean<Favorite> pageBean=favoriteService.findByPage(uid,curPage);
            resultInfo=new ResultInfo(true,pageBean,"查询我的收藏成功哦啦");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"查询我的收藏失败啦");

        }finally {
            data = objectMapper.writeValueAsString(resultInfo);
            System.out.println("收藏数据" + data);
            resp.getWriter().print(data);
        }

    }

    public void addFavorite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=null;
        ResultInfo resultInfo=null;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap <String,Object>();
        try {
            String rid = req.getParameter("rid");
            User user = (User)req.getSession().getAttribute("user");
            if(user==null){
                map.put("isLogin",false);
                resultInfo = new ResultInfo(true, map, "没有登录哦");

            }else {
                favoriteService.addFavorite(user.getUid(),rid);
                int count=routService.findByRid(rid).getCount();
                map.put("isLogin",true);
                map.put("count",count);
                resultInfo= new ResultInfo(true,map,"登录了并且收藏成功");

            }
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"服务器异常");
        }finally {
            data=objectMapper.writeValueAsString(resultInfo);
            System.out.println("收藏到的数据" + data);
            resp.getWriter().print(data);

        }
    }

    public void isEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=null;
        ResultInfo resultInfo=null;
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap <String,Object>();
        try {
            User user = (User)req.getSession().getAttribute("user");
            if(user==null){
                map.put("isEdit",true);
                resultInfo=new ResultInfo(true,map,"没有登录");
            }else {
                String rid=req.getParameter("rid");
                boolean isFavorite=favoriteService.isFavorite(user.getUid(),rid);
                if(isFavorite){
                    map.put("isEdit",false);
                    resultInfo = new ResultInfo(true, map, "登陆了但是已经收藏了");

                }else {
                    map.put("isEdit",true);
                     resultInfo = new ResultInfo(true, map, "登录过但没有收藏");
                }
                }

        } catch (Exception e) {
            e.printStackTrace();
            new ResultInfo(false,null,"服务器异常");
        }finally {
            data=objectMapper.writeValueAsString(resultInfo);
            System.out.println("是否可编译的data=" + data);
            resp.getWriter().print(data);
        }

    }
}
