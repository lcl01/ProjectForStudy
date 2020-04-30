package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {

    @Select("select * from user1")
    @Results(id="userMap" ,value={
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "address",column = "address"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "accounts",column = "id",many = @Many(select = "com.itheima.dao.AccountDao.findByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    List<User> findUserAccountList();
    @Insert("insert into user1(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",keyColumn = "id",before = false,resultType = Integer.class)

    void saveUser(User user);
    @Delete("delete from user1 where id=#{id} ")
    void deleteUser(Integer userId);
    @Select("select * from user1 where username like #{username}")
    @ResultMap(value = "userMap")
    List<User> findUserByName(String username);
    @Select("select * from user1 where id=#{uid}")
    User findById(Integer id);
}


