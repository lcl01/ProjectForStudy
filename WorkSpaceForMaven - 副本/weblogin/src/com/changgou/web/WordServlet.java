package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.Words;
import com.itheima.service.WordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/word")
public class WordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String keyword = req.getParameter("keyword");
            //2.调用业务, 获得List
            WordService wordService = new WordService();
            List<Words> list =  wordService.findByKeyWord(keyword);
            //3.使用jackson把list转成json ,响应给客户端
            ObjectMapper objectMapper = new ObjectMapper();
            String data = objectMapper.writeValueAsString(list);
            System.out.println("data="+data);
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
