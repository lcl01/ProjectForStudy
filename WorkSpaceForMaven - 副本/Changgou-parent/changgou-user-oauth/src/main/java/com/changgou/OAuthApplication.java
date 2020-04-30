package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

/*****
 * @Author: shenkunlin
 * @Date: 2019/7/6 8:01
 * @Description: com.health
 ****/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.health.user.feign"})
@MapperScan(basePackages = "com.health.auth.dao")
public class OAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthApplication.class,args);
    }


    @Bean(name = "restTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}