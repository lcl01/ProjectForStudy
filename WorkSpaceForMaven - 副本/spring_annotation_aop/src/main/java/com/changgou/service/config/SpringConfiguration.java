package com.changgou.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.itheima")
@EnableAspectJAutoProxy
public class SpringConfiguration {

}
