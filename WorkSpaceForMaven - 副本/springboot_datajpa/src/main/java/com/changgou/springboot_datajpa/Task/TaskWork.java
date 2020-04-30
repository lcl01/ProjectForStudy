package com.changgou.springboot_datajpa.Task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskWork {
    @Scheduled(cron="1/2 * * * * *")
    public void taskDoSomthing(){
        System.out.println("定时任务执行了taskDoSomthing，当前时间:" + LocalDateTime.now());
    }
}
