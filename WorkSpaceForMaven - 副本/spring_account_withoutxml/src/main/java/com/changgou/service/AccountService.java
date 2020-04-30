package com.changgou.service;

import com.changgou.beans.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void save(Account account);
    void delete(Integer id);
    void update(Account account);
}
