package com.itheima.springboot_cloud_resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootCloudResttemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCloudResttemplateApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
