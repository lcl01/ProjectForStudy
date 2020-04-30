package com.itheima.service;

import com.itheima.beans.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void save(Account account);
    void delete(Integer id);
    void update(Account account);
}
