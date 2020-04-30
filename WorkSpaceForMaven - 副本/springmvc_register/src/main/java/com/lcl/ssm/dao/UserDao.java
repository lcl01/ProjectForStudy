package com.lcl.ssm.dao;

import com.lcl.ssm.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserDao {
    @Insert("insert into user(number,password,mobile) values(#{number},#{password},#{mobile})")
    int save(User user);
    @Select("select * from user where number=#{number} and password=#{password}")
    User findByNumberAndPassword(User user);
}
