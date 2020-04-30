package com.lcl.service.impl;

import com.lcl.bean.Account;
import com.lcl.dao.AccountDao;
import com.lcl.service.AccountService;

import java.util.List;

public class AccountServiceImpl1 implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void saveAccount(Account account) {

    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public Account findAccountByName(String accountName) {
        return accountDao.findAccountByName(accountName);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);

    }

    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }

    public void transfer(String sourName, String targetName, Float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(source);

        int i=1/0;

        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}
