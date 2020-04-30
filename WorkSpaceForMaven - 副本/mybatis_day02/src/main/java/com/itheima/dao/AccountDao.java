package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    List<Account> findByAccountUser();
    @Select(value = "select * from account where uid = #{uid}")
    List<Account> findByUid(Integer uid);
    @Select("select * from account")
    @Results(id="accountMap", value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user",column = "uid",one = @One(select = "com.itheima.dao.UserDao.findById",fetchType = FetchType.LAZY))
    })

    List<Account> findAll();
    @Select(value = "select u.*,a.id as aid ,a.uid,a.money from account a,user u where a.uid=u.id")
    @Results(id="accountUserMap",value={
            @Result(id = true,property = "id",column = "aid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user.id",column = "id"),
            @Result(property = "user.username",column = "username"),
            @Result(property = "user.sex",column = "sex"),
            @Result(property = "user.address",column = "address"),
            @Result(property = "user.birthday",column = "birthday"),
    })
    List<Account> findAllAccountUser2();


}
