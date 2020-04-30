package com.ithema.springboot_rabbitmq_producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
//    创建交换机
    @Bean(name="topicExchange")
    public TopicExchange topicExchange(){
        return new TopicExchange("topic_exchange_springboot");
    }
//    创建队列
    @Bean(name="topicQueueSpringBoot")
    public Queue topicQueue(){
        return QueueBuilder.durable("topic_queue_springboot").build();
    }
//    队列绑定交换机
    @Bean
    public Binding bindingExchangeTopicQueue(@Qualifier("topicQueueSpringBoot")Queue queue,
                                             @Qualifier("topicExchange")Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("log.#").noargs();
    }
}
