package com.lcl.service;

import com.lcl.bean.Account;

import java.util.List;

public interface AccountService {
    void saveAccount(Account account);
    List<Account> findAllAccount();
    Account findAccountById(Integer accountId);
    Account findAccountByName(String accountName);
    void updateAccount(Account account);
    void deleteAccount(Integer acccountId);
    void transfer(String sourName,String targetName,Float money);
}
