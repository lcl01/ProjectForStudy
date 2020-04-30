package com.itheima.feign.fallback;

import com.itheima.domain.User;
import com.itheima.feign.UserClient;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient{
    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setUsername("jianjifuwufu及服务");
        return user;
    }
}
