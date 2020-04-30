package com.lcl.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcl.dubbo.service.TestService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Reference
    private TestService testService;
    @RequestMapping("/sayhello")
    public String sayHello(){
        return testService.sayHello();
    }
}
