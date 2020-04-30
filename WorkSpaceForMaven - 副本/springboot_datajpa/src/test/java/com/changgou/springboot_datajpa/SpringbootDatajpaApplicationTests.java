package com.changgou.springboot_datajpa;

import com.changgou.springboot_datajpa.bean.User;
import com.changgou.springboot_datajpa.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class SpringbootDatajpaApplicationTests {
@Autowired
private UserService userService;
    @Test
    void contextLoads() {
        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

}
