package com.lcl.factory;

import com.lcl.service.AccountService;
import com.lcl.service.impl.AccountServiceImpl1;
import com.lcl.utills.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory1 {
    private AccountService accountService;

    private TransactionManager txManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public AccountService getAccountService() {
       return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               Object rtValue = null;
               try {
                   txManager.beiginTransaction();
                   rtValue = method.invoke(accountService, args);
                   txManager.commit();
                   return rtValue;
               } catch (Exception e) {
                   txManager.rollback();
                   throw new RuntimeException(e);

               }finally {
                   txManager.release();
               }

           }
       });
    }
}
