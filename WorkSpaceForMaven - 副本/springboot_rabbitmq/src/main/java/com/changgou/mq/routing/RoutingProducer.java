package com.changgou.mq.routing;

import com.changgou.mq.utils.ConnectionUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class RoutingProducer {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        //创建频道channel
        Channel channel = connection.createChannel();
        //声明交换机- channel.exchangeDeclare(交换机名字,交换机类型)
        channel.exchangeDeclare("routing_exchange", BuiltinExchangeType.DIRECT);
        for (int i = 0; i < 3; i++) {
            String routingKey = "";
            //发送消息的时候根据相关逻辑指定相应的routing key。
            switch (i){
                case 0:  //假设i=0，为error消息
                    routingKey = "log.error";
                    break;
                case 1: //假设i=1，为info消息
                    routingKey = "log.info";
                    break;
                case 2: //假设i=2，为warning消息
                    routingKey = "log.warning";
                    break;
            }
            String message="hahsf,llc李龙城"+i;
            channel.basicPublish("routing_exchange",routingKey,null,message.getBytes("utf-8"));

        }
        channel.close();
        connection.close();

    }
}
