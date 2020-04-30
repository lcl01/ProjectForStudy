package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private int i=1;
    public void saveAccount() {
        AccountDao accountDao=(AccountDao) BeanFactory.getBean("accountDao");
        int i=1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
