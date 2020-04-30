package com.itheima.dao;

import com.itheima.beans.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAllAccount();
    Account findAccountById(Integer id);
    void save(Account account);
    void delete(Integer id);
    void update(Account account);
}
