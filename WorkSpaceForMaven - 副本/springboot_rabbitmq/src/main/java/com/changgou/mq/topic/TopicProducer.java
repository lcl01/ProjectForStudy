package com.changgou.mq.topic;

import com.changgou.mq.utils.ConnectionUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
//#：匹配一个或多个词
//*：匹配不多不少恰好1个词
public class TopicProducer {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        //8、创建频道-channel = connection.createChannel()
        Channel channel = connection.createChannel();
        //声明交换机- channel.exchangeDeclare(交换机名字,交换机类型)
        channel.exchangeDeclare("topic_exchange", BuiltinExchangeType.TOPIC);
        for (int i = 0; i < 5; i++) {
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
                case 3: //假设i=3，为log.info.add消息
                    routingKey = "log.info.add";
                    break;
                case 4: //假设i=4，为log.info.update消息
                    routingKey = "log.info.update";
                    break;
            }
            //10、创建消息-String m = xxx
            String message = "hello,欢迎来到深圳黑马！" + i;
            //11、消息发送-channel.basicPublish(交换机[默认Default Exchage],路由key[简单模式可以传递队列名称],消息其它属性,消息内容)
            channel.basicPublish("topic_exchange",routingKey,null,message.getBytes("utf-8"));
        }
        channel.close();
        connection.close();
    }
}
