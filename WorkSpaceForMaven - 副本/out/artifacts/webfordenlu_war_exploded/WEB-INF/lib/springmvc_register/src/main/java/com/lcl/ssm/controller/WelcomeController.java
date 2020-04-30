package com.lcl.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/index")
public class WelcomeController {
    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "index";
    }
}
