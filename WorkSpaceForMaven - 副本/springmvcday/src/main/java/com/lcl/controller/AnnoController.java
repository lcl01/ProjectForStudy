package com.lcl.controller;

import com.lcl.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(path = "/anno")
public class AnnoController {
    @RequestMapping(path = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "name") String username,
                                   @RequestParam(value="age",required = true)Integer age){
        System.out.println("Hello SpringMVC!!，测试@RequestParam");
        System.out.println(username);
        System.out.println(age);
        return "success";// 响应结果
    }
    @RequestMapping(path = "/testRequestBody")
    public String testRequestBody(@RequestBody(required = false) String body){
        System.out.println("Hello SpringMVC!!，测试@RequestParam");
        System.out.println(body);
        return "success";// 响应结果
    }
    @RequestMapping(path = "/testPathVariable/{uid}")
    public String testPathVariable(@PathVariable(value = "uid") Integer id){
        System.out.println("Hello SpringMVC!!，测试@PathVariable");
        System.out.println(id);
        return "success";// 响应结果
    }
    @RequestMapping(path = "/testPathVariable",method = RequestMethod.POST)
    public String save(User user){
        System.out.println("Hello SpringMVC!!，测试@PathVariable，新增-请求方式Post");
        System.out.println(user);
        return "success";// 响应结果
    }
    // 请求参数
    @RequestMapping(path = "/testPathVariable",method = RequestMethod.PUT)
    public String update(User user){
        System.out.println("Hello SpringMVC!!，测试@PathVariable，更新-请求方式Put");
        System.out.println(user);
        return "success";// 响应结果
    }
    // 请求参数
    @RequestMapping(path = "/testPathVariable/{uid}",method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "uid") Integer id){
        System.out.println("Hello SpringMVC!!，测试@PathVariable，删除-请求方式Delete");
        System.out.println(id);
        return "success";// 响应结果
    }
    // 请求参数
    @RequestMapping(path = "/testPathVariable/{uid}",method = RequestMethod.GET)
    public String findById(@PathVariable(value = "uid") Integer id){
        System.out.println("Hello SpringMVC!!，测试@PathVariable，查询一个-请求方式Get");
        System.out.println(id);
        return "success";// 响应结果
    }
    @RequestMapping(path = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="accept")String requestHeader){
        System.out.println("Hello SpringMVC!!，测试@RequestHeader");
        System.out.println(requestHeader);
        return "success";// 响应结果
    }
    @RequestMapping(path = "/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID")String cookieValue){
        System.out.println("Hello SpringMVC!!，测试@CookieValue");
        System.out.println(cookieValue);
        return "success";// 响应结果
    }
    @ModelAttribute // 在执行的方法之前运行
    public void showModel(User user) {
        System.out.println("执行了showModel方法"+user);

    }

    /** * 模拟修改用户方法 * @param user * @return */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("控制器中处理请求的方法：修改用户："+user);
        return "success";
    }
//    private User findUserByName(String username) {
//        User user = new User();
//        user.setUsername(username);
//        user.setAge(19);
//        user.setBirthday(new Date());
//        return user;
//    }

}
