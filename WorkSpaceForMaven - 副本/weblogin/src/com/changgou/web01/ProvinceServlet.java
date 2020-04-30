package com.changgou.web01;

import com.changgou.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html;charset=utf-8");
            ProvinceService provinceService = new ProvinceService();
            String data =  provinceService.findAll();
            System.out.println("data =" + data);
            resp.getWriter().print(data);
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
