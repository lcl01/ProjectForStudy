package com.itheima.web.servlet;

import com.itheima.bean.Customer;
import com.itheima.service.impl.CustomerService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/demoServlet")
public class DemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
            Map<String,String[]> map = req.getParameterMap();
            Customer customer = new Customer();
            BeanUtils.populate(customer,map);
            CustomerService customerService = new CustomerService();
            customerService.addCustomer(customer);
            resp.getWriter().print("success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
