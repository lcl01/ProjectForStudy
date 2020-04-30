package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.PageBean;
import com.itheima.bean.ResultInfo;
import com.itheima.bean.Route;
import com.itheima.service.RoutService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/route")
public class RouteServlet extends BaseServlet {
    private RoutService routService=new RoutService();
    public void findSelected(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=null;
        ResultInfo resultInfo=null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String,List<Route>> map=routService.findSelect();
            resultInfo = new ResultInfo(true, map, "精选路线成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(true, null, "精选路线失败");

        }finally {
            data = objectMapper.writeValueAsString(resultInfo);
            System.out.println("lc.L精选" + data);
            resp.getWriter().print(data);
        }
    }

    public void findByRid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=null;
        ResultInfo resultInfo=null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String rid=req.getParameter("rid");
            Route route=routService.findByRid(rid);
            resultInfo = new ResultInfo(true, route, "旅游路线详情查询成功！");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "旅游路线详情查询失败！");

        }finally {
            data = objectMapper.writeValueAsString(resultInfo);
            System.out.println("详情查询" + data);
            resp.getWriter().print(data);
        }
    }

    public void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=null;
        ResultInfo resultInfo=null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            int cid = Integer.parseInt(req.getParameter("cid"));
            int curPage =Integer.parseInt( req.getParameter("curPage"));
            String rname=req.getParameter("rname");
            PageBean<Route> pageBean=routService.findByPage(cid,curPage,rname);
            resultInfo = new ResultInfo(true, pageBean, "分页查询成功");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "分页查询失败");

        }finally {
             data = objectMapper.writeValueAsString(resultInfo);
            System.out.println("后台数据" + data);
            resp.getWriter().print(data);
        }
    }
}
