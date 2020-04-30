package com.itheima.feign;

import com.itheima.domain.User;
import com.itheima.feign.conf.FeignConfig;
import com.itheima.feign.fallback.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user-provider",fallback = UserClientFallback.class,
                configuration =FeignConfig.class)
public interface UserClient {
//    @RequestMapping("/user/find/{id}")
//    public User findById(@PathVariable("id")Integer id);
    @RequestMapping("/user/find/{id}")
    User findById(@PathVariable("id") Integer id);

}
