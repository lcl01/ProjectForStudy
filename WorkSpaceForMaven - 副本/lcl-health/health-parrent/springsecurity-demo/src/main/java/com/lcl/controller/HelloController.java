package com.lcl.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Stream;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/add")
    @PreAuthorize("hasAuthority('add')")
    public String add(){
        System.out.println("add...");
        return null;
    }
    @RequestMapping("/delete")
    @PreAuthorize("hasAuthority('delete')")
    public String delete(){
        System.out.println("delete");
        return null;
    }
}
