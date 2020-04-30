package com.lcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaServer
//@RequestMapping
public class eurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(eurekaApplication.class,args);
    }
}
