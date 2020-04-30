package com.health.application.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.health.constant.MessageConstant;
import com.health.constant.RedisMessageConstant;
import com.health.pojo.Member;
import com.health.pojo.Result;
import com.health.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Reference
    private MemberService memberService;
    @Autowired
    private JedisPool jedisPool;
    @RequestMapping("/check")
    public Result check(HttpServletResponse response, @RequestBody Map map){
        String telephone = (String) map.get("telephone");
        String validateCode = (String) map.get("validateCode");
        String codeInRedis=jedisPool.getResource().get(telephone+ RedisMessageConstant.SENDTYPE_LOGIN);
        if (codeInRedis==null|| !codeInRedis.equals(validateCode)) {
            return new Result(false, MessageConstant.VALIDATECODE_ERROR);
        }else {
            Member member=memberService.findByTelephone(telephone);
            if (member==null) {
                 member = new Member();
                 member.setPhoneNumber(telephone);
                 member.setRegTime(new Date());
                 memberService.add(member);
            }
            return new Result(true,MessageConstant.SEND_VALIDATECODE_SUCCESS);
        }
    }
}
