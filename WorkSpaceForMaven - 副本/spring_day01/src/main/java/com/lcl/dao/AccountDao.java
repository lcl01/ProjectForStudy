package com.lcl.dao;

import com.lcl.bean.Account;

import java.util.List;

public interface AccountDao {
    void saveAccount(Account account);
    List<Account> findAllAccount();
    Account findAccountById(Integer accountId);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
    Account findAccountByName(String accountName);
}
