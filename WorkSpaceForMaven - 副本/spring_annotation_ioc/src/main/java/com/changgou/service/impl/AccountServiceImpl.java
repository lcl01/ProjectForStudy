package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("accountService")
@Scope("prototype")
public class AccountServiceImpl implements AccountService {
    @Autowired
//    @Qualifier("accountDao")配合Autowired使用;
    private AccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("构造方法...");
    }
    @PostConstruct
    public void  init(){
        System.out.println("初始化方法执行了");
    }

    @PreDestroy
    public void  destroy(){
        System.out.println("销毁方法执行了");
    }
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
