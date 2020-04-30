package com.changgou.mq.work;

import com.changgou.mq.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class WorkConsumerOne {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("workqueue",true,false,false,null);
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //路由的key
                String routingKey = envelope.getRoutingKey();
                //获取交换机信息
                String exchange = envelope.getExchange();
                //获取消息ID
                long deliveryTag = envelope.getDeliveryTag();
                //获取消息信息
                String message = new String(body,"utf-8");
                System.out.println(
                        "routingKey:" + routingKey +
                                ",exchange:" + exchange +
                                ",deliveryTag:" + deliveryTag +
                                ",message:" + message);

            }
        };
        channel.basicConsume("workqueue",true,consumer);
    }
}
