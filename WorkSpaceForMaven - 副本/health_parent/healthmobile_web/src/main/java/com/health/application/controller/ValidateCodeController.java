package com.health.application.controller;

import com.health.constant.MessageConstant;
import com.health.constant.RedisMessageConstant;
import com.health.pojo.Result;
import com.health.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {
    @Autowired
    private JedisPool jedisPool;
    //体检预约时发送手机验证码
    @RequestMapping("/send4Order")
    public Result send4Order(String telephone) {
        Integer code = ValidateCodeUtils.generateValidateCode(6);
        try {
//            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE,telephone,code.toString());
            System.out.println("发送的手机验证码为：" + code);
            //将生成的验证码缓存到redis
            jedisPool.getResource().setex(
                    telephone + RedisMessageConstant.SENDTYPE_ORDER,5 * 60,code.toString());
            //验证码发送成功
            return new Result(true,MessageConstant.SEND_VALIDATECODE_SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
    }
    @RequestMapping("/send4Login")
    public Result send4Login(String telephone) {
        Integer code = ValidateCodeUtils.generateValidateCode(6);
        try {
//            SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE,telephone,code.toString());
            System.out.println("发送的手机验证码为：" + code);
            //将生成的验证码缓存到redis
            jedisPool.getResource().setex(
                    telephone + RedisMessageConstant.SENDTYPE_LOGIN,5 * 60,code.toString());
            //验证码发送成功
            return new Result(true,MessageConstant.SEND_VALIDATECODE_SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
    }

}
