package com.lcl.ssm.service;

import com.lcl.ssm.domain.Account;

import java.util.List;

public interface AccountService {
    public List<Account> findAll();

    public void saveAccount(Account account);
}
