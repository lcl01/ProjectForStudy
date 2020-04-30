package com.changgou.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(value = {"com.itheima"})
@Import(value = JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {

}
