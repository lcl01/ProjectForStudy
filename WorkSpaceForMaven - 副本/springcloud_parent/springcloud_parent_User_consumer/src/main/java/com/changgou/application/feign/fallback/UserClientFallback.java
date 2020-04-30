package com.itheima.application.feign.fallback;

import com.itheima.application.domain.User;
import com.itheima.application.feign.UserClient;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    /**
     * 服务降级实现
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setUsername("Fallback，Feign服务降级。。。");
        return user;
    }
}
