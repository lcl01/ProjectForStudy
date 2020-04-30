package com.changgou.mq.simple;

import com.changgou.mq.utils.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SimpleProducer {
    public static void main(String[] args) throws Exception {
//        //1、创建链接工厂对象-factory=new ConnectionFactory()
//        ConnectionFactory factory = new ConnectionFactory();
//        //2、设置RabbitMQ服务主机地址，默认localhost-factory.setHost("localhost")
//        factory.setHost("localhost");
//        //3、设置RabbitMQ服务端口，默认-1-factory.setPort(5672)
//        factory.setPort(5672);
//        //4、设置虚拟主机名字，默认/-factory.setVirtualHost("szitheima")
//        factory.setVirtualHost("/szitheima");
//        //5、设置用户连接名，默认guest-factory.setUsername("admin")
//        factory.setUsername("admin");
//        //6、设置链接密码，默认guest-factory.setPassword("admin")
//        factory.setPassword("admin");
//        //7、创建链接-connection=factory.newConnection()
//        Connection connection = factory.newConnection();
//        //8、创建频道-channel = connection.createChannel()
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //9、声明队列-channel.queueDeclare(名称，是否持久化，是否独占本连接,是否自动删除,附加参数)
        channel.queueDeclare("simple_queue",true,false,false,null);
        //10、创建消息-String m = xxx
        String message="hello 李龙城eaear";
        //11、消息发送-channel.basicPublish(交换机[默认Default Exchage],路由key[简单模式可以传递队列名称],消息其它属性,消息内容)
        channel.basicPublish("","simple_queue",null,message.getBytes("utf-8"));
        //12、关闭资源-channel.close();connection.close()
        channel.close();
        connection.close();
    }
}
