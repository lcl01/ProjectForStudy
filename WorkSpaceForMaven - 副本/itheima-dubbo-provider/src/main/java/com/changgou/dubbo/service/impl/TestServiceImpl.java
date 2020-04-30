package com.itheima.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dubbo.service.TestService;
import org.springframework.transaction.annotation.Transactional;

@Service(loadbalance = "random",interfaceClass = TestService.class)
@Transactional
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello() {
        return "LLChello";
    }
}
