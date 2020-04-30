package com.changgou.mq.fanout;

import com.changgou.mq.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class FanoutConsumerOne {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("fanoutqueue",true,false,false,null);
        //队列绑定交换机-channel.queueBind(队列名, 交换机名, 路由key[广播消息设置为空串])
        channel.queueBind("fanoutqueue","fanout_exchange","");
        DefaultConsumer consumer = new DefaultConsumer(channel){
            /**
             * @param consumerTag 消费者标签，在channel.basicConsume时候可以指定
             * @param envelope 消息包的内容，可从中获取消息id，消息routingkey，交换机，消息和重传标志(收到消息失败后是否需要重新发送)
             * @param properties  属性信息(生产者的发送时指定)
             * @param body 消息内容
             * @throws IOException
             */
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
channel.basicConsume("fanoutqueue",true,consumer);
    }
}
