package com.lcl.test;

import com.lcl.bean.Account;
import com.lcl.config.SpringConfiguration;
import com.lcl.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:applicationContext.xml")
public class AccountServiceTest {
    @Autowired
    @Qualifier("proxyAccountService")
    private AccountService as;
    @Test
    public void testTrasfer(){
        as.transfer("aaa","bbb",100f);
    }
//    public void testFindAll(){
//        List <Account> allAccount = as.findAllAccount();
//        for (Account account : allAccount) {
//            System.out.println(account);
//        }
//    }
//    @Test
//    public void testTransfer(){
//        as.transfer("aaa","bbb",100f);
//    }
//    @Test
//    public void testFindAll(){
//      ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AccountService as = ac.getBean("accountService", AccountService.class);
//        as.transfer("aaa","bbb",100f);
//
//    }
//    @Test
//    public  void testfindAccounbById(){
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);
//        Account accountById = accountService.findAccountById(2);
//        System.out.println(accountById);
//    }
//    @Test
//    public void test(){
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AccountService as = ac.getBean("accountService",AccountService.class);
//        Account account = new Account();
//        account.setName("张鑫3");
//        account.setMoney(520f);
//        as.saveAccount(account);
//
//    }
//    @Test
//    public void testUpdata(){
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AccountService accountServie = applicationContext.getBean("accountService",AccountService.class);
//        Account accountById = accountServie.findAccountById(5);
//        accountById.setMoney(1314f);
//        accountServie.updateAccount(accountById);
//    }
//    @Test
//    public void testDelete(){
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
//        accountService.deleteAccount(4);
//    }
//    @Test
//    public void testFindAll1(){
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        AccountService accountService = ac.getBean("accountService",AccountService.class);
////        AccountService accountService1 = ac.getBean("accountService",AccountService.class);
////        System.out.println(accountService == accountService1);
//        List <Account> allAccount = accountService.findAllAccount();
//        for (Account account : allAccount) {
//            System.out.println(account);
//        }
////
//    }
}

