package com.changgou.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.changgou.dubbo.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controller {

//    @Reference
    @Reference(check = false,loadbalance = "random")
    private TestService testService;
    @RequestMapping("/sayhello")
    public String sayHello(){
        return testService.sayHello();
    }
}
