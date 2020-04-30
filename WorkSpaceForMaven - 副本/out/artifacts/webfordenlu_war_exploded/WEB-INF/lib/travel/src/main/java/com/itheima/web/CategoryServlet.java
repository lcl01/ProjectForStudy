package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.ResultInfo;
import com.itheima.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/catagory")
public class CategoryServlet extends BaseServlet{
    private  CategoryService categoryService= new CategoryService();

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data=null;
        ResultInfo resultInfo=null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String categoryData=categoryService.findAll();
            resultInfo=new ResultInfo(true,categoryData,"出现类别成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo = new ResultInfo(false, null, "查询失败");
        }
finally {
            data = objectMapper.writeValueAsString(resultInfo);
            System.out.println("类别数据" + data);
            resp.getWriter().print(data);
        }
    }
}
