package com.health.application.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.health.constant.MessageConstant;
import com.health.constant.RedisMessageConstant;
import com.health.pojo.Order;
import com.health.pojo.Result;
import com.health.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Reference
    private OrderService orderService;
    @Autowired
    private JedisPool jedisPool;
    @RequestMapping("/submit")
    public Result submitOrder(@RequestBody Map map){
        String telephone = (String) map.get("telephone");
        //从Redis中获取缓存的验证码，key为手机号+RedisConstant.SENDTYPE_ORDER
        String codeInRedis = jedisPool.getResource().get(
                telephone + RedisMessageConstant.SENDTYPE_ORDER);
        String validateCode = (String) map.get("validateCode");
        //校验手机验证码
        if(codeInRedis == null || !codeInRedis.equals(validateCode)){
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }
        Result result =null;
        //调用体检预约服务
        try{
            map.put("orderType", Order.ORDERTYPE_WEIXIN);
            result = orderService.order(map);
        }catch (Exception e){
            e.printStackTrace();
            //预约失败
            return result;
        }
        if (result.isFlag()) {
            String orderDate = (String) map.get("orderDate");
            try {
//                SMSUtils.sendShortMessage(SMSUtils.ORDER_NOTICE,telephone,orderDate);
                System.out.println(1 == 1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Result result =null;
        try {
            result = orderService.findById4Detail(id);
            return new Result(true,MessageConstant.QUERY_ORDER_SUCCESS,result.getData());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_ORDER_FAIL);
        }

    }
}
