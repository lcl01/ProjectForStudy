package com.lcl.controller;

import com.lcl.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("salary")
    public String salary(Model model)
    {
        System.out.println("有梦想终究，努力了终究会实现");
        model.addAttribute("salary","20");
        ArrayList <User> users = new ArrayList <User>();
        users.add(new User(1,"张三","深圳"));
        users.add(new User(2,"李四","北京"));
        users.add(new User(3,"王五","武汉"));
        model.addAttribute("users",users);
        Map<String, Object> dataMap = new HashMap <String, Object>();
        dataMap.put("No","23");
        dataMap.put("Address","深圳");
        model.addAttribute("dataMap",dataMap);
        String[] names={"张三","李四","王五"};
        model.addAttribute("names",names);
        model.addAttribute("time",new Date());
        model.addAttribute("age",23);
        return "demo1";
    }
}
