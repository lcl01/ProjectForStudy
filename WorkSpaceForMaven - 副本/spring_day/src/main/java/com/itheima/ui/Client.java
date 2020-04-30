package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.AccountService;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            AccountService as=(AccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
