package com.changgou.factory;

import com.itheima.service.AccountService;
import com.itheima.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    private AccountService accountService;

    private TransactionManager txManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }
    public AccountService getAccountService(){
        AccountService accountService02=(AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                try {
                    txManager.beginTransaction();
                    //2.执行操作
                    rtValue = method.invoke(accountService, args);
                    //3.提交事务
                    txManager.commit();
                    //4.返回结果
                    return rtValue;
                } catch (IllegalAccessException e) {
                    txManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    txManager.release();
                }

            }
        });
        return accountService02;
    }
}
