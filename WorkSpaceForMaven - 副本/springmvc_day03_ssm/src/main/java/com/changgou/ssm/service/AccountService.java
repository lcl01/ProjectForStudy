package com.itheima.ssm.service;

import com.itheima.ssm.domain.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();
    public void saveAccount(Account account);
}
