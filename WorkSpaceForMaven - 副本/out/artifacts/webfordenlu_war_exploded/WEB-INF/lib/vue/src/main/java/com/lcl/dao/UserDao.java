package com.lcl.dao;

import com.lcl.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    @Select(value = "select * from user ")
    List<User> findAll();
    @Select(value = "select * from user where id=#{id}")
    User findOne(Integer id);
    @Update(value = "update user set username=#{username},password=#{password},sex=#{sex},age=#{age},email=#{email} where id=#{id}")
    int update(User user);
}
