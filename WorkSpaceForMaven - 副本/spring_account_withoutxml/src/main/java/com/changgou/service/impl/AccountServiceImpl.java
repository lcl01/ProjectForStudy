package com.changgou.service.impl;

import com.changgou.beans.Account;
import com.changgou.dao.AccountDao;
import com.changgou.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    @Qualifier(value = "accountDao")
    private AccountDao accountDao;
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void save(Account account) {
        accountDao.save(account);
    }

    public void delete(Integer id) {
        accountDao.delete(id);
    }

    public void update(Account account) {
        accountDao.update(account);

    }
}
