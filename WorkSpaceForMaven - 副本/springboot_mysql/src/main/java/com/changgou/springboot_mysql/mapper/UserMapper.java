package com.itheima.springboot_mysql.mapper;

import com.itheima.springboot_mysql.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();

}
