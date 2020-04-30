package com.lcl.service.impl;

import com.lcl.domain.User;
import com.lcl.mapper.UserMapper;
import com.lcl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> findAll() {
        String key="UserList";
       List<User> users =(List<User>) redisTemplate.boundValueOps(key).get();
       if (users!=null){
//           for (User user : users) {
//               System.out.println(user);
//           }
           return users;
       }
       users=userMapper.findAll();
        redisTemplate.boundValueOps(key).set(users);
        return users ;
    }
}
