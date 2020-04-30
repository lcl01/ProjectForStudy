package com.itheima.service.Impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        System.out.println("AccountServiceImpl 保存了账户");
//        ApplicationContext ass = new ClassPathXmlApplicationContext("applicationContext.xml");
//        accountDao= (AccountDao) ass.getBean("accountDao");
        accountDao.saveAccount();
    }
    public void  init(){
        System.out.println("对象初始化了。。。");
    }
    public void  destroy(){
        System.out.println("对象销毁了。。。");
    }
}
