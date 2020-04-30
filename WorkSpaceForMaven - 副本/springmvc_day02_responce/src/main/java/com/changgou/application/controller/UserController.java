package com.itheima.controller;

import com.itheima.domain.User.User;
import com.changgou.exception.SysException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value ="/user")
public class UserController {
    @RequestMapping(value = "/re")
    public String responser(){
        System.out.println("响应");
        return "response";
    }
    @RequestMapping(value = "/up")
    public String update(){
        System.out.println("响应");
        return "update";
    }
    @RequestMapping(value = "/userc")
    public String testFileUpload(){
        System.out.println("执行了testFileUpload方法！");
        return "fileUp";
    }

    // 返回字符串
    @RequestMapping(path="/testReturnString")
    public String testReturnString(){
        System.out.println("执行了testReturnString方法！");
        return "success";
    }
    @RequestMapping("/testFileUpload1")
    public String testFileUpload1(HttpServletRequest request) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> list = fileUpload.parseRequest(request);
        for (FileItem fileItem : list) {
            if (fileItem.isFormField()) {

            }else {
                String filename = fileItem.getName();
                // 生成唯一标识
                String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                filename = uuid+"_"+filename;
                // 上传文件
                fileItem.write(new File(file, filename));
                // 删除临时文件
                fileItem.delete();
            }
        }
        return "success";
    }
    @RequestMapping("/testFileUpload2")
    public String testFileUpload2(HttpServletRequest request,MultipartFile upload) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        filename=uuid+"_"+filename;
        upload.transferTo(new File(file,filename));
        return "success";
    }
    /**
     * 跨服务器上传文件，把文件上传到图片服务器中去
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/testFileUpload3")
    public String testFileUpload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器上传文件...");

        // 指定上传文件的路径
        String path = "http://localhost:9090/springmvc_response02/upload/";

        // 获取到文件的名称
        String filename = upload.getOriginalFilename();
        // 生成唯一标识
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        filename = uuid+"_"+filename;

        // 上传文件
        // 创建客户端对象
        Client client = Client.create();
        filename = path+filename;
        // 连接图片服务器
        WebResource webResource = client.resource(filename);
        // 把文件上传到图片服务器上
        webResource.put(upload.getBytes());

        return "success";
    }
    /**
     * 请求参数的绑定
     */
    @RequestMapping(value="/userUpdate")
    public String userUpdate(Model model) {
        // 模拟从数据库中查询的数据，在页面上进行回显
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setAge(18);
        model.addAttribute("user", user);
        System.out.println(user);
        return "success";
    }
    // 无返回值
    @RequestMapping(path="/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("执行了testVoid方法！");
        System.out.println("请求转发或者重定向");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
// 1：请求转发
  request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        // 2：重定向
//  response.sendRedirect(request.getContextPath()+"/index.jsp");
        // 3：直接响应数据
//        response.getWriter().print("你好");
        return;
    }
    @RequestMapping(value="/testModelAndView")
    public ModelAndView testModelAndView() throws Exception {
        ModelAndView mv = new ModelAndView();
        // 默认执行视图解析器，跳转到WEB-INF/pages/success.jsp的页面
        mv.setViewName("success");

        // 模拟从数据库中查询所有的用户信息
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("张三");
        user1.setPassword("123");

        User user2 = new User();
        user2.setUsername("赵四");
        user2.setPassword("456");

        list.add(user1);
        list.add(user2);
        // 添加对象
        mv.addObject("list", list);

        return mv;
    }
//    @RequestMapping("/testForwardOrRedirect")
//    public String testForwardOrRedirect() throws Exception {
//        System.out.println("testForwardOrRedirect方法执行了...");
////        return "forward:/WEB-INF/pages/success.jsp";
//        return "forward:/user/testReturnString";
//    }
 @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() throws Exception {
        System.out.println("testForwardOrRedirect方法执行了...");
//        return "forward:/WEB-INF/pages/success.jsp";
        return "redirect:/user/testReturnString";
    }
    @RequestMapping("/testJson")
    public @ResponseBody User testJson(@RequestBody User user) {
        System.out.println(user);
        // 响应u
        User u = new User();
        u.setUsername("张三");
        u.setPassword("123");
        u.setAge(18);
        return u;
    }
    @RequestMapping("/testException")
    public String testException()throws SysException {
        System.out.println("执行了testException方法！");
        try {
            int a = 10/0;
        } catch (Exception e) {
            throw new SysException("服务器繁忙");
        }
        return "success";
    }
    // 自定义拦截器
    @RequestMapping(path="/testInterceptor")
    public String testInterceptor(){
        System.out.println("执行了testInterceptor方法！");
        return "success";
    }
}
