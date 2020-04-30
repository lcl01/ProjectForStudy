package com.lcl.ssm.service.impl;

import com.lcl.ssm.dao.AccountDao;
import com.lcl.ssm.dao.UserDao;
import com.lcl.ssm.domain.Account;
import com.lcl.ssm.domain.User;
import com.lcl.ssm.service.AccountService;
import com.lcl.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有的帐户...");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存帐户...");
        accountDao.saveAccount(account);
    }

    public static class UserServiceImpl implements UserService {
        @Autowired
        private UserDao userDao;
        @Override
        public int saveUser(User user) {
            return userDao.save(user);
        }
    }
}
