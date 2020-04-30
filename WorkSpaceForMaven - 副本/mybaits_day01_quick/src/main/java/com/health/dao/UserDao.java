package com.health.dao;

import com.health.beans.QueryVo;
import com.health.beans.User02;
import com.health.beans.User03;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有
     */
    List<User02> findAll();
    void saveUser02(User02 user02);
    void updateUser(User02 user02);
    void delete(Integer userid);
    User02 findById(Integer userId);
    List<User02> findByName(String name);
    int findTotal();
    List<User02> findUserByVo(QueryVo vo);
    List<User03> findAll01();
    List<User03> findAll02();
    List<User02> findCondition(User02 user02);
    List<User02> findInIds(QueryVo queryVo);
    List<User02> UserRoleList();
}
