package com.changgou.controller;

import com.changgou.mode.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/test")
public class TestController {
    /***
     * 访问/test/hello  跳转到demo1页面
     * @param model
     * @return
     */
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("nihao","nihao01 welcome");
        //集合数据
        List<User> users = new ArrayList<User>();
        users.add(new User(1,"张三","深圳"));
        users.add(new User(2,"李四","北京"));
        users.add(new User(3,"王五","武汉"));
        model.addAttribute("users",users);
        //Map定义
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("no","123/");
        dataMap.put("address","深圳");
        model.addAttribute("dataMap",dataMap);
        String[] names={"张三","李四","王五"};
        model.addAttribute("names",names);
        model.addAttribute("now",new Date());
        model.addAttribute("age",22);
        return "demo01";
    }
}
