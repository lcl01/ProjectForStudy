package com.itheima.dao;

import com.itheima.beans.Account;
import com.itheima.beans.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;
@CacheNamespace(blocking = true)
public interface UserDaolcl {
    @Select(value = "select * from user02")
    @Results(id = "userMap",value = {
            @Result(id=true,property ="id",column = "id"),
            @Result(property="username",column = "username"),
            @Result(property="address",column = "address"),
            @Result(property="sex",column = "sex"),
            @Result(property="birthday",column = "birthday"),
            @Result(property = "accounts",column = "id",many = @Many(
                    select = "com.itheima.mapper.AccountDaolcl.findByUid",fetchType = FetchType.LAZY)
            )
    })
    List<User> findAll();
    @Insert("insert into user02(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",keyColumn = "id",before = false,resultType = Integer.class)
    void saveUser(User user);
    @Update("update user02 set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where id=#{id}")
    void updateUser(User user);
    @Delete("delete from user02 where id=#{id} ")
    void deleteUser(Integer userId);

    @Select("select * from user02  where id=#{uid} ")
    @ResultMap(value = "userMap")
    User findById(@Param(value = "uid")Integer userId);

    @Select("select * from user02 where username like '%${value}%' ")
    List<User> findUserByName(String username);
    @Select("select count(*) from user02 ")
    int findTotalUser();
    @Select(value = "select * from user02 where username like #{name} and sex = #{sex}")
    List<User> findByNameAndSex(@Param(value = "name") String username,@Param(value = "sex") String sex);
    @Select(value = "select * from user02 where username like #{name} and sex = #{sex}")
    List<User> findByNameAndSex2(Map map);
}
