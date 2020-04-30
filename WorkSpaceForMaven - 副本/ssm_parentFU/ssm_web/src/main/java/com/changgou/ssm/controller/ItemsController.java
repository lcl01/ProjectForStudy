package com.changgou.ssm.controller;

import com.changgou.ssm.service.ItemsService;
import com.itheima.ssm.domain.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @RequestMapping("/list")
    public String list(Model model){
        //集合查询
        List<Items> items = itemsService.list();
        //存入回显
        model.addAttribute("items",items);
        return "items";
    }
    @RequestMapping("/save")
    public String save(Items items){
        String name = items.getName();
        Float price = items.getPrice();
        int acount =  itemsService.save(items);
        //集合列表页跳转
        return "redirect:/items/list";
    }
}

