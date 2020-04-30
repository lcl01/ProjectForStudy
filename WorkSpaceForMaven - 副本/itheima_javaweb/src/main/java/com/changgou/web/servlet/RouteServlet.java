package com.itheima.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.PageBean;
import com.itheima.bean.ResultInfo;
import com.itheima.bean.Route;
import com.itheima.service.impl.RouteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/route")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteService();

    public void findSelected(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, List<Route>> map =  routeService.findSelected();
            resultInfo = new ResultInfo(true,map,"精选线路查询成功!");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo=new ResultInfo(false,null,"精选线路查询失败!");

        }finally {
            data=objectMapper.writeValueAsString(resultInfo);
            System.out.println("黑马精选的data=" + data);
            resp.getWriter().print(data);
        }

    }
    public void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
//            String cid1 = req.getParameter("cid");
//            System.out.println("cid=" + cid1);
            int cid = Integer.parseInt(req.getParameter("cid"));
            int curPage = Integer.parseInt(req.getParameter("curPage"));
            PageBean<Route> pageBean =  routeService.findByPage(cid,curPage);
            resultInfo  = new ResultInfo(true,pageBean,"分页查询成功!");

        } catch (Exception e) {
            e.printStackTrace();
            resultInfo  = new ResultInfo(false,null,"分页查询失败!");
        }finally {
            data = objectMapper.writeValueAsString(resultInfo);
            System.out.println("data=" + data);
            resp.getWriter().print(data);
        }
    }
    public void findByRid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String rid = req.getParameter("rid");
            //2.调用业务
            Route route =  routeService.findByRid(rid);
            resultInfo = new ResultInfo(true,route,"旅游线路详情查询成功!");

        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false,null,"旅游线路详情查询失败!");
        }finally {
            data=objectMapper.writeValueAsString(resultInfo);
            resp.getWriter().print(data);
        }

    }

}
