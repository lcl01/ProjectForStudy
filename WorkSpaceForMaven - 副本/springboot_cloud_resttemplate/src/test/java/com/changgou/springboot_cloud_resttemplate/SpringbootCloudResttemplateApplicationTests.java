package com.itheima.springboot_cloud_resttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SpringbootCloudResttemplateApplicationTests {
    @Autowired
    private RestTemplate restTemplate;
    @Test
    void contextLoads() {
        String url="http://localhost:18081/user/list";
        String jsion=restTemplate.getForObject(url,String.class);
        System.out.println(jsion);
    }

}
