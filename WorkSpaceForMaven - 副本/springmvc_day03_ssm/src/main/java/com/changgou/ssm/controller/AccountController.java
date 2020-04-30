package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Account;
import com.itheima.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    @Qualifier(value = "accountService")
    public AccountService accountService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层：查询所有账户...");
         List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        model.addAttribute("list",list);
        return"success";
    }
    @RequestMapping("/save")
    public String saveAccount(Account account){
        System.out.println("表现层：保存账户...");
        accountService.saveAccount(account);
        return "redirect:/account/findAll";
    }
}
