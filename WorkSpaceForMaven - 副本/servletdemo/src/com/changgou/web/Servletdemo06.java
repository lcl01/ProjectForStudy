package com.itheima.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletdemo06",urlPatterns = "/count")
public class Servletdemo06 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        getServletContext().setAttribute("count",0);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String file01="a.mp3";
//        String file02 = "b.png";
//        String mimeType01=getServletContext().getMimeType(file01);
//        String mimeType02=getServletContext().getMimeType(file02);
//        response.getWriter().print("servlet06"+":1"+mimeType01+":"+mimeType02);
        ServletContext servletContext = getServletContext();
        int count=(int)servletContext.getAttribute("count");
        count++;
        servletContext.setAttribute("count",count);

        response.getWriter().print("<h1>Welcome</h1>");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
