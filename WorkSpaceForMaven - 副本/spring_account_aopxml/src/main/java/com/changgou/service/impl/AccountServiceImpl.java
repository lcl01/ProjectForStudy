package com.changgou.service.impl;

import com.changgou.beans.Account;
import com.changgou.dao.AccountDao;
import com.changgou.service.AccountService;
import com.changgou.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    @Qualifier(value = "accountDao")
    private AccountDao accountDao;
    private TransactionManager txManager;

//    public TransactionManager getTxManager() {
//        return txManager;
//    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try {//1.开启事务
            txManager.beginTransaction();
            List<Account> allAccount = accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            return allAccount;
        } catch (Exception e) {
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {

        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public Account findAccountByName(String accountName) {
        return accountDao.findAccountByName(accountName);
    }

    public void transfer(String sourceName, String targetName, Float money) {
//        try {
            //1.开启事务
//            txManager.beginTransaction();
            System.out.println("transfer....");
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney((target.getMoney()+money));
//            int i=1/0;
            accountDao.updateAccount(target);
            accountDao.updateAccount(source);
            //3.提交事务
//            txManager.commit();
//        } catch (Exception e) {
            //4.回滚操作
//            txManager.rollback();
//            e.printStackTrace();
//        }finally {
            //5.释放连接
//            txManager.release();
//        }
    }


}
