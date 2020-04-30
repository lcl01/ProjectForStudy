package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
//@Repository
public interface AccountDao {
    @Select("select * from account")
    public List<Account> findAll();
    @Insert("insert into account (name,money) values(#{name},#{money})")
    public void saveAccount(Account account);

}
