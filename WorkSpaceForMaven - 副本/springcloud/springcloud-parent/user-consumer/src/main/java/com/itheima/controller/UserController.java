package com.itheima.controller;

import com.itheima.domain.User;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/consumer")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @HystrixCommand(fallbackMethod = "failBack")
    @GetMapping(value = "/{id}")
    public User queryById(@PathVariable(value = "id")Integer id){
        String url = "http://user-provider/user/find/"+id;
//        List<ServiceInstance> instances=discoveryClient.getInstances("user-provider");
//        ServiceInstance serviceInstance=instances.get(0);
//        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/find/"+id;
        return restTemplate.getForObject(url,User.class);
    }
    public User failBack(Integer id){
        User user = new User();
        user.setUsername("服务降级,默认处理！");
        return  user;
    }
}
