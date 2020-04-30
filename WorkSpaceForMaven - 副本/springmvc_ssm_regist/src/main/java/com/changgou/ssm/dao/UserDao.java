package com.itheima.ssm.dao;

import com.itheima.ssm.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Insert("insert into user(number,password,mobile) values(#{number},#{password},#{mobile})")
    int saveUser(User user);
//    @Select("select * from user where number=#{number} and password=#{password}")
//    public User findByNumberAndPassword(User user);
    @Select("select * from user where number = #{number} and password=#{password}")
    public User findByNumberAndPassword(@Param("number") String number, @Param("password") String password);

}
