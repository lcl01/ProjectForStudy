package com.changgou.mq.simple;

import com.changgou.mq.utils.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class SimpleConsumer {
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
        //创建消费者
        DefaultConsumer callback = new DefaultConsumer(channel){
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
        /**
         * 消息消费
         * 参数1：队列名称
         * 参数2：是否自动应答，true为自动应答[mq接收到回复会删除消息]，设置为false则需要手动应答
         * 参数3：消息接收到后回调
         */
        channel.basicConsume("simple_queue",true,callback);

    }
}
