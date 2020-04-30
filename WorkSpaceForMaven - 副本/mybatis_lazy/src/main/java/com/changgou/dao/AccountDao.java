package com.itheima.dao;

import com.changgou.beans.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findByAccountUser();
    List<Account> findAccountByUid(Integer uid);
}
