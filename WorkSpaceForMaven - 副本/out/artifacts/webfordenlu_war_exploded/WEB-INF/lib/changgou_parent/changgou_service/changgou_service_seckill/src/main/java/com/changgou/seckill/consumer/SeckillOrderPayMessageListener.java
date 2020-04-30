package com.changgou.seckill.consumer;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 秒杀支付消息监听器
 * @author Steven
 * @description com.changgou.seckill.consumer
 */
@Component
public class SeckillOrderPayMessageListener {
    @RabbitListener(queues = "${mq.pay.queue.seckillorder}")
    public void payListener(String msg){
        //将数据转成Map
        Map<String, String> result = JSON.parseObject(msg, Map.class);
        System.out.println("收到消息，参数为：" + result);
        //return_code=SUCCESS
        String return_code = result.get("return_code");
        if ("success".equalsIgnoreCase(return_code)) {
            //业务结果
            String result_code = result.get("result_code");
            //获取订单号
            String out_trade_no = result.get("out_trade_no");
            //交易流水号
            String transaction_id = result.get("transaction_id");
            //附加参数
            Map<String, String> attachMap = JSON.parseObject(result.get("attach"), Map.class);
            //用户名
            String username = attachMap.get("username");
            //业务结果-SUCCESS/FAIL，为success时，支付成功
            if ("success".equalsIgnoreCase(result_code)) {

            }else {

            }
        }

    }
}
