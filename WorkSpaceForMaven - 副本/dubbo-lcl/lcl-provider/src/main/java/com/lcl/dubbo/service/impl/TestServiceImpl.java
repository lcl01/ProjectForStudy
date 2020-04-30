package com.lcl.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcl.dubbo.service.TestService;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = TestService.class)
@Transactional
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello() {
        return "hello";
    }
}
