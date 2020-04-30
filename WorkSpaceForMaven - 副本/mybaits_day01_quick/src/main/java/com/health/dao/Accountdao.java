package com.health.dao;

import com.health.beans.Account;
import com.health.beans.AccountUser;
import com.health.beans.User02;

import java.util.List;

public interface Accountdao {
    List<Account> findAll();
    Account findById(Integer id);
    List<AccountUser> findByAccountUser();
    List<Account> findAll01();
    List<User02> findAll02();
}
