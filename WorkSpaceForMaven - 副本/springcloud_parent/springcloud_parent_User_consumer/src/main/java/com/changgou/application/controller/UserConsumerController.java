package com.itheima.application.controller;

import com.itheima.application.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
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
@RequestMapping("/consumer")
//刚才把fallback写在了某个业务方法上，如果方法很多，可以将FallBack配置加在类上，实现默认FallBack
//@DefaultProperties(defaultFallback=”defaultFailBack“)，在类上，指明统一的失败降级方法；
@DefaultProperties(defaultFallback = "defaultFailBack")
public class UserConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient; //此对象用于向注册中心获取服务列表
    @GetMapping("/{id}")
//    使用HystrixCommon注解，定义
//    @HystrixCommand(fallbackMethod="failBack")用来声明一个降级逻辑的fallback兜底方法
//    @HystrixCommand(fallbackMethod = "failBack")
    @HystrixCommand
    public User queryById(@PathVariable(value = "id")Integer id){
//        String url="http://localhost:18081/user/find/"+id;
//        String url="http://user-provider/user/find/"+id;
//        return restTemplate.getForObject(url,User.class);
        //获取指定生产者的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");
        //获取第一个实例对象
        ServiceInstance instance = instances.get(0);
        String url="http://"+instance.getHost()+":"+instance.getPort()+"/user/find/"+id;
        return  restTemplate.getForObject(url,User.class);
    }
    /****
     * 服务降级处理方法
     * @return
     */
    public User failBack(Integer id){
        User user = new User();
        user.setUsername("服务降级啦");
        return user;
    }
    /****
     * 全局的服务降级处理方法
     * @return
     */
    public User defaultFailBack(){
        User user = new User();
        user.setUsername("Default-服务降级,默认处理！");
        return  user;
    }
}
