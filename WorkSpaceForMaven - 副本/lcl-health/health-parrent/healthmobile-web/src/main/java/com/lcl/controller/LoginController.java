package com.lcl.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcl.constant.MessageConstant;
import com.lcl.constant.RedisMessageConstant;
import com.lcl.entity.Result;
import com.lcl.pojo.Member;
import com.lcl.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
   @Reference
    public MemberService memberService;
   @Autowired
    public JedisPool jedisPool;
   @RequestMapping("/check")
   public Result check(HttpServletRequest request, @RequestBody Map map) {
//       String telephone = (String) map.get("telephone");
//       String validateCode = (String) map.get("validateCode");
//       //从Redis中获取缓存的验证码
//       String codeInRedis = jedisPool.getResource().get(
//               telephone + RedisMessageConstant.SENDTYPE_LOGIN);
//       if(codeInRedis == null || !codeInRedis.equals(validateCode)){
//           //验证码输入错误
//           return new Result(false,MessageConstant.LOGIN_SUCCESS);
//       }else{
//           //验证码输入正确
//           //判断当前用户是否为会员
//           Member member = memberService.findByTelephone(telephone);
//           if(member == null){
//               //当前用户不是会员，自动完成注册
//               member = new Member();
//               member.setPhoneNumber(telephone);
//               member.setRegTime(new Date());
//               memberService.add(member);
//           }
//           Cookie cookie = new Cookie("login_member_telephone",telephone);
//           cookie.setMaxAge(60*60*24*30); // 有效期秒
//           cookie.setPath("/");// 设置为网站的根路径，当访问到这个网站就会带上cookie
//           response.addCookie(cookie); // 给客户端写cookie
////           System.out.println("11");
//           return new Result(true,MessageConstant.LOGIN_SUCCESS);
//       }
//   }
//}
       try {
           String telephone = (String) map.get("telephone");
           String validateCode = (String) map.get("validateCode");
           String codeInRedis = jedisPool.getResource().get(telephone + RedisMessageConstant.SENDTYPE_LOGIN);
           if (codeInRedis == null || !codeInRedis.equals(validateCode)) {
               return new Result(false, MessageConstant.VALIDATECODE_ERROR);
           } else {
               Member member = memberService.findByTelephone(telephone);
               if (member == null) {
                   member = new Member();
                   member.setPhoneNumber(telephone);
                   member.setRegTime(new Date());
                   memberService.add(member);
               }
               request.getSession().setAttribute("member",member);
               return new Result(true,MessageConstant.LOGIN_SUCCESS);
           }
       } catch (Exception e) {
           e.printStackTrace();
           return new Result(false,MessageConstant.ADD_CHECKITEM_FAIL);
       }

}
}
