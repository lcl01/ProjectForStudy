package com.itheima.dao;
import com.changgou.beans.User;

import java.util.List;

public interface UserDao {
    User findById(Integer id);
    List<User> findByUserAccount();

}
