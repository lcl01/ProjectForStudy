package com.itheima.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.dubbo.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Reference
    public TestService testService;
    @RequestMapping("/sayhello")
    @ResponseBody
    public String sayHello(String name){

        return testService.sayHello(name);
    }


}
