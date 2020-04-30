package com.changgou.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/hello01")
    public String hello(){
        return "helloSpringboot02";
    }
}
