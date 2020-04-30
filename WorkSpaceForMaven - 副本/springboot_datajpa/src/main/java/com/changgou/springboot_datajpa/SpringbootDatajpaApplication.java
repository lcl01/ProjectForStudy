package com.changgou.springboot_datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//开启定时任务
public class SpringbootDatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDatajpaApplication.class, args);
    }

}
