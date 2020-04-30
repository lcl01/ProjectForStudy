package com.lcl.ssm.dao;

import com.lcl.ssm.domain.User;
import org.apache.ibatis.annotations.Insert;

public interface UserDao {
    @Insert("insert into user(number,password,mobile)values(#{number},#{password},#{mobile})")
    int save(User user);
}
