package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.service.TestService;
@Service(protocol = "dubbo",interfaceClass = TestService.class)
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello(String name) {
        System.out.println("服务的sayHello方法被调用！");
        return "hello " + name;
    }
}
