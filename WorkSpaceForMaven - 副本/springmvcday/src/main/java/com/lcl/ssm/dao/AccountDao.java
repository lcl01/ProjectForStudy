package com.lcl.ssm.dao;

import com.lcl.ssm.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountDao {
    @Select(value = "select * from account")
    public List<Account> findAll();
    @Insert(value = "insert into account(name,money) value(#{name},#{money})")
    public  void saveAccount(Account account);

}
