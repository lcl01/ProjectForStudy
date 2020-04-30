package com.changgou.springboot_rabbitmq_consumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    /**
     * 监听某个队列的消息
     * @param msg 接收到的消息
     */
    @RabbitListener(queues = "topic_queue_springboot")
    public void topicListener(String msg){
        System.out.println("接受消息：" + msg);
    }
}
