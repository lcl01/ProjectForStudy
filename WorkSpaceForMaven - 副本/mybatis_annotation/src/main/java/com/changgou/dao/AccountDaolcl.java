package com.itheima.dao;

import com.itheima.beans.Account;
import com.itheima.beans.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface AccountDaolcl {
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,property = "id",column = "ID"),
            @Result(property = "uid",column = "UID"),
            @Result(property = "money",column = "MONEY"),
//            @Result(property = "user",column = "uid",one=@One(
//                select="com.itheima.mapper.UserDaolcl.findById",fetchType= FetchType.LAZY)
//            )
    })
    List<Account> findAll();
    @Select(value = "select * from account where UID=#{id}")
    @ResultMap("accountMap")
    List<Account> findByUid(Integer uid);

    @Select(value = "SELECT u.*,a.ID AS aid,a.UID,a.MONEY FROM account a,user02 u WHERE a.UID = u.id")
    @Results(id = "accountUserMap",value = {
            @Result(id = true,property = "id",column = "aid"),
            @Result(property ="uid",column = "UID"),
            @Result(property = "money",column = "MONEY"),
            @Result(property = "user.id",column = "id"),
            @Result(property = "user.username",column = "username"),
            @Result(property = "user.sex",column = "sex"),
            @Result(property = "user.address",column = "address"),
            @Result(property = "user.birthday",column = "birthday"),
    })
    List<Account> findAllAccountUser2();
}
