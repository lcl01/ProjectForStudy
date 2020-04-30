package com.itheima.service.Impl;

import com.itheima.service.AccountService;

import java.util.Date;

public class AccountServiceImpl01 implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl01() {
    }

    public AccountServiceImpl01(String name, Integer age, Date birthday) {

        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了。。。"+name+","+age+","+birthday);
    }
}
