package com.coder520.POI.user.dao;

import com.coder520.POI.user.entity.User;
import com.coder520.POI.user.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
@MapperScan
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> findAllUser();
    List<Integer> getUserId();
}