package com.changgou.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "IllegalFilter",urlPatterns = "/IllegalFilter")
public class IllegalFilter implements Filter {
    private List<String> illegalWords=new ArrayList<String>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {
            InputStream is = filterConfig.getServletContext().getResourceAsStream("IllegalWords.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String line=null;
            while ((line=reader.readLine())!=null){
                illegalWords.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String message = request.getParameter("message");
        for (String illegalWord : illegalWords) {
            if (message != null && message.trim().contains(illegalWord)) {
                response.getWriter().write("含有非法字符，请重新发表言论");
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
