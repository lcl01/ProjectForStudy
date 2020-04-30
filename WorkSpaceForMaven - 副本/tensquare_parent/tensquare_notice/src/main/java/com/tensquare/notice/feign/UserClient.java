package com.tensquare.notice.feign;

import com.tensquare.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("tensquare-user")
public interface UserClient {
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    Result findById(@PathVariable(value = "userId") String userId);
}
