package com.itheima.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
//@EnableEurekaClient //开启Eureka客户端发现功能，注册中心只能是Eureka
@EnableDiscoveryClient //开启Eureka客户端发现功能(推荐使用)
public class UserProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class,args);
    }
}
