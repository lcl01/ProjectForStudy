package com.lcl.controller;

import com.lcl.domain.User;
import com.lcl.exception.SysException;
import com.lcl.exception.SysExceptionResolver;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.MultipartStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @RequestMapping(path="/testReturnString")
    public String testReturnString(){
        System.out.println("执行了testReturnString方法！");
        return "success";
    }
    @RequestMapping(value="/userUpdate")
    public String userUpdate(Model model) {
        // 模拟从数据库中查询的数据，在页面上进行回显
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setAge(18);
        model.addAttribute("user", user);
        return "update";
    }
    @RequestMapping(value="/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("请求转发或者重定向");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好");
        return;
    }
    @RequestMapping(value = "/testModeAndView")
    public ModelAndView modelAndView()throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        List<User> list = new ArrayList <>();
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        User user1 = new User();
        user1.setUsername("张");
        user1.setPassword("234");
        list.add(user);
        list.add(user1);
        modelAndView.addObject("list",list);
        return modelAndView;
    }
    @RequestMapping(value = "/testForwardOrRedirect")
    public String testForwardOrRedirect() throws Exception {
        System.out.println("testForwardOrRedirect方法执行了...");
//        return "forward:/WEB-INF/pages/success.jsp";
        return "forward:/user/testReturnString";
    }
    @RequestMapping(value = "/testForwardOrRedirect1")
    public String testForwardOrRedirect1() throws Exception {
        System.out.println("testForwardOrRedirect方法执行了...");
//        return "redirect:/index.jsp";
        return "redirect:/user/testReturnString";
    }
    @RequestMapping("/testJson")
    @ResponseBody
    public User testJson(@RequestBody User user) {
        System.out.println(user);
        User u = new User();
        u.setUsername("张三");
        u.setPassword("123");
        u.setAge(18);
        return u;

//        return "redirect:/user/testReturnString";
    }
    @RequestMapping("/testFileUpload")
    public String testFileUpload(HttpServletRequest request) throws Exception {

        System.out.println("执行testFileUpload");
        String path=request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        List <FileItem> fileItems = fileUpload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {

            }else {
                String filename = fileItem.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                filename=uuid+"_"+filename;
                fileItem.write(new File(file,filename));
                fileItem.delete();
            }
        }
        return "success";
    }
    @RequestMapping("/testFileUpload1")
    public String testFileUpload1(HttpServletRequest request, MultipartFile upload) throws IOException {
        String path=request.getSession().getServletContext().getRealPath("/uploads");
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
    @RequestMapping("/testException")
    public String testException() throws SysExceptionResolver, SysException {
        System.out.println("异常");
        try {
            int a=10/1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("服务器繁忙");
        }
        return "error";
    }
    @RequestMapping(path="/testInterceptor")
    public String testInterceptor(){
        System.out.println("执行了testInterceptor方法！");
        return "success";
    }
}
