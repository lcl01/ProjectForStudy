package com.lcl.dao1;

import com.lcl.domain.QueryVo;
import com.lcl.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    User findById(Integer id);
    List<User> findByName(String name);
    int findTotal();
    List<User> findUserByVo(QueryVo vo);

}
