package com.tensquare.article;

import com.tensquare.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * 文章微服启动类
 */
@SpringBootApplication
@MapperScan("com.tensquare.article.dao")
@EnableEurekaClient
@EnableFeignClients
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
    /**
     * 解决key值乱码
     * @param redisTemplate
     */
    @Resource
    public void redisKeySerializer(RedisTemplate redisTemplate){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
    }
}
