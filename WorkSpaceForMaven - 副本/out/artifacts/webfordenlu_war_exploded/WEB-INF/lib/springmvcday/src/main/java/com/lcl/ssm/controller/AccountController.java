package com.lcl.ssm.controller;

import com.lcl.ssm.domain.Account;
import com.lcl.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Controller
@RequestMapping(path = "account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "/findAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有账户...");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        for (Account account : list) {
            System.out.println(account);
        }
        return "success";
    }
    @RequestMapping(path = "/save")
    public String saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层：保存账户...");

        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return "success";
    }

}
