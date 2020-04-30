package com.changgou.mq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class WorkProducer {
    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setVirtualHost("/szitheima");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //连续发10条消息
        for (int i = 0; i < 10; i++) {
            //9、声明队列-channel.queueDeclare(名称，是否持久化，是否独占本连接,是否自动删除,附加参数)
            channel.queueDeclare("workqueue",true,false,false,null);
            String message="hellfdafallc李龙城";
            channel.basicPublish("","workqueue",null,message.getBytes("utf-8"));
        }
        channel.close();
        connection.close();


    }
}
