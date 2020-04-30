package com.itheima.springboot_mysql.service.impl;

import com.itheima.springboot_mysql.bean.User;
import com.itheima.springboot_mysql.mapper.UserMapper;
import com.itheima.springboot_mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public List<User> findAll() {
        List<User> userList = (List<User>) redisTemplate.boundValueOps("userList").get();
        if (userList==null|| userList.size()<1) {
            userList=userMapper.findAll();
            redisTemplate.boundValueOps("userList").set(userList);
        }else {
            System.out.println("从缓存redis读取");
        }
        return userList;
    }
}
