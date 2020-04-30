package com.lcl.controller;

import com.aliyuncs.exceptions.ClientException;
import com.lcl.constant.MessageConstant;
import com.lcl.constant.RedisMessageConstant;
import com.lcl.entity.Result;
import com.lcl.utils.SMSUtils;
import com.lcl.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

@RestController
@RequestMapping("/validateCode")
public class ValidateCodeController {
    @Autowired
    private JedisPool jedisPool;
    @RequestMapping("/send4Order")
    public Result send4Order(String telephone){
        Integer code = ValidateCodeUtils.generateValidateCode(4);
        try {
            SMSUtils.sendShortMessage(SMSUtils.VAlIDATE_CODE,telephone,code.toString());
        } catch (ClientException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        System.out.println("发送的手机验证码为：" + code);
        jedisPool.getResource().setex(telephone+ RedisMessageConstant.SENDTYPE_ORDER,10000*60,code.toString());
        return  new Result(true,MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }
    @RequestMapping("/send4Login")
    public Result send4Login(String telephone){
        Integer code=ValidateCodeUtils.generateValidateCode(6);
        try {
            SMSUtils.sendShortMessage(SMSUtils.VAlIDATE_CODE,telephone,code.toString());

        } catch (ClientException e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.SEND_VALIDATECODE_FAIL);
        }
        System.out.println("发送的手机验证码为：" + code);
        jedisPool.getResource().setex(telephone+RedisMessageConstant.SENDTYPE_LOGIN,10000*60,code.toString());
        return new Result(true,MessageConstant.SEND_VALIDATECODE_SUCCESS);
    }

}
