package com.changgou.mq.fanout;

import com.changgou.mq.utils.ConnectionUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class FanoutProducer {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机- channel.exchangeDeclare(交换机名字,交换机类型)
        channel.exchangeDeclare("fanout_exchange", BuiltinExchangeType.FANOUT);
        //连续发10条消息
        for (int i = 0; i < 10; i++) {
            //10、创建消息-String m = xxx
            String message = "hello,欢迎来到深圳黑马！" + i;
            channel.basicPublish("fanout_exchange","",null,message.getBytes("utf-8"));

        }
        channel.close();
        connection.close();
    }
}
