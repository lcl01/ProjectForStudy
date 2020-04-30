package com.itheima.controller;


import com.itheima.domain.Account;
import com.itheima.domain.User;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/param")
@SessionAttributes(value ={"username","password"},types={Integer.class})
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("hello");
        return "success";
    }
    @RequestMapping("/hello01")
    public String sayHello01(){
        System.out.println("hello01");
        return "param";
    }
@RequestMapping("/hello02")
    public String sayHello02(){
        System.out.println("hello02");
        return "param01";
    }
@RequestMapping("/anno")
    public String sayHello03(){
        System.out.println("hello02");
        return "anno";
    }

    // 请求参数
    @RequestMapping(path = "/testRequestMapping",method = {RequestMethod.GET},params = {"username=haha"},headers = "accept")
    public String testRequestMapping(){
        System.out.println("Hello SpringMVC!!，测试testRequestMapping方法");
        return "success";// 响应结果
    }
    // 请求参数
    @RequestMapping(path = "/testParam")
    public String testParam(String username,Integer age){
        System.out.println("params测试：username:"+username+"age:"+age);
        return "success";// 响应结果
    }
    @RequestMapping(value = "/testParam01")
    public String testParam(User user){
        System.out.println("欢迎执行ParamController中的testParam方法！user:"+user);
        return "success";// 执行视图解析器  /WEB-INF/page/success.jsp
    }
    @RequestMapping(path = "/saveAccount")
    public String testParam(Account account){
        System.out.println(account);
        return "success";// 响应结果
    }
    @RequestMapping(value = "/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return"success";
    }
    @RequestMapping(path = "/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request:"+request);
        System.out.println("session:"+request.getSession());
        System.out.println("application:"+request.getSession().getServletContext());
        System.out.println("response:"+response);
        return "success";// 响应结果
    }
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "name") String username,@RequestParam(value = "age",required = true)Integer age){
        System.out.println(username +"   "+ age);
        return "success";
    }
    @RequestMapping(value = "/testRequestBody")
    public String testRequestBody(@RequestBody(required = false) String body){
        System.out.println(body);
        return "success";
    }
    @RequestMapping(path = "/testPathVariable/{uid}")
    public String testPathVariable(@PathVariable(value = "uid") Integer id){
        System.out.println("Hello SpringMVC!!，测试@PathVariable");
        System.out.println(id);

        return "success";
    }
    @RequestMapping(path = "/testPathVariable",method = RequestMethod.POST)
    public String save(User user){
        System.out.println("Hello SpringMVC!!，测试@PathVariable，新增-请求方式Post");
        System.out.println(user);
        return "success";// 响应结果
    }
    @RequestMapping(path = "/testPathVariable",method = RequestMethod.PUT)
    public @ResponseBody String update(User user){
        System.out.println("Hello SpringMVC!!，测试@PathVariable，更新-请求方式Put");
        System.out.println(user);
        return "success";// 响应结果
    }
    @RequestMapping(path = "/testPathVariable/{uid}",method = RequestMethod.DELETE)
    public @ResponseBody String delete(@PathVariable(value = "uid") Integer id){
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
//        @ModuleAttributes()
    @ModelAttribute // 在执行的方法之前运行
    public void showModel(User user) {
        System.out.println("执行了showModel方法"+user);
        user.setBirthday(new Date());
    }
    /** * 模拟修改用户方法 * @param user * @return */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user) {
        System.out.println("控制器中处理请求的方法：修改用户："+user);
        return "success";
    }
    @ModelAttribute // 在执行的方法之前运行
    public User showModel(String username) {
        //模拟去数据库查询
        User user = findUserByName(username);
        System.out.println("执行了showModel方法"+user);
        return user;
    }
    @RequestMapping("/testModelAttribute01")
    public String testModelAttribute01(User user) {
        System.out.println("控制器中处理请求的方法：修改用户："+user);
        return "success";
    }
    private User findUserByName(String username) {
        User user = new User();
        user.setUsername(username);
        user.setAge(19);
        user.setBirthday(new Date());
        return user;
    }
    @ModelAttribute // 在执行的方法之前运行
    public void showModel(String username, Map<String,User> maps) {
        //模拟去数据库查询
        User user = findUserByName(username);
        maps.put("abc",user);
        System.out.println("执行了showModel方法"+user);
    }
    @RequestMapping("/testModelAttribute02")
    public String testModelAttribute02(@ModelAttribute(value = "abc") User user) {
        System.out.println("控制器中处理请求的方法：修改用户："+user);
        return "success";
    }
    @RequestMapping("/sessionAttributePut")
    public String testPut(Model model){
        System.out.println("把数据存入SessionAttribute");
        model.addAttribute("username", "泰斯特");
        model.addAttribute("password","123456");
        model.addAttribute("age", 31);
        //跳转之前将数据保存到username、password和age中，因为注解@SessionAttribute中有这几个参数
        return "success";
    }
    /**
     * * 获取SessionAttribute
     */
    @RequestMapping("/sessionAttributeGet")
    public String testGet(ModelMap model){
        System.out.println("获取SessionAttribute");
        System.out.println(model.get("username")+";"+model.get("password")+";"+model.get("age"));
        return "success";
    }
    /**
     * * 清空SessionAttribute
     */
    @RequestMapping("/sessionAttributeClean")
    public String complete(SessionStatus sessionStatus){
        System.out.println("清空SessionAttribute");
        sessionStatus.setComplete();
        return "success";
    }
}
