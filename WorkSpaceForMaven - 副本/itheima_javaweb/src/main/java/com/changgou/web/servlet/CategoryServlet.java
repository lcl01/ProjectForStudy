package com.itheima.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.ResultInfo;
import com.itheima.service.impl.CategoryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category")
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService = new  CategoryService();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String data = null;
        ResultInfo resultInfo = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String categoryData =  categoryService.findAll();
            resultInfo = new ResultInfo(true,categoryData,"查询类别成功!");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false,null,"查询类别失败!");
        }finally {
            data = objectMapper.writeValueAsString(resultInfo);
            System.out.println("类别的数据=" + data);
            response.getWriter().print(data);
        }
    }

}
