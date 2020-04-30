package com.ithema.springboot_rabbitmq_producer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbitmqProducerApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
    }
//    测试生产者
    @Test
    public void TestSendMessage(){
        //convertAndSend(交换机名称，路由key,消息内容)
        rabbitTemplate.convertAndSend("topic_exchange_springboot","log.info","发送了info消息");
        rabbitTemplate.convertAndSend("topic_exchange_springboot","log.erro","发送了error消息");
        rabbitTemplate.convertAndSend("topic_exchange_springboot","log.waring","发送了waring消息");


    }
}
