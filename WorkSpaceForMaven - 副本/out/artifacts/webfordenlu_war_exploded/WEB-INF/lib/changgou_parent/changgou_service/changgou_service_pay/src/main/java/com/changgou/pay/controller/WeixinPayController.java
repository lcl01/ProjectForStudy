package com.changgou.pay.controller;

import com.alibaba.fastjson.JSON;
import com.changgou.pay.service.WeixinPayService;
import com.github.wxpay.sdk.WXPayUtil;
import entity.Result;
import entity.StatusCode;
import org.apache.commons.io.IOUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/weixin/pay")
@CrossOrigin
public class WeixinPayController {
    @Autowired
    private WeixinPayService weixinPayService;
    /***
     * 创建二维码
     * @param paramMap {
     *                 out_trade_no 订单号,
     *                 total_fee 金额(分),
     *                 exchange 交换机,
     *                 routingKey 路由Key
     *                 }
     * @return
     */
    @RequestMapping(value = "/create/native")
    public Result createNative(@RequestParam Map<String,String> paramMap){
        //paramMap.put("username", TokenDecode.getUserInfo().get("username"));
        paramMap.put("username", "zhangsan");
        Map<String,String> resultMap = weixinPayService.createNative(paramMap);
        return new Result(true, StatusCode.OK,"创建二维码预付订单成功！",resultMap);
    }
    @GetMapping(value = "/status/query")
    public Result queryStatus(String out_trade_no){
        Map<String,String> resultMap = weixinPayService.queryPayStatus(out_trade_no);
        return new Result(true,StatusCode.OK,"查询状态成功！",resultMap);
    }
    /***
     * 支付回调
     * 支付完成后，微信会把相关支付结果及用户信息通过数据流的形式发送给商户，
     * 商户需要接收处理，并按文档规范返回应答
     * @param request
     * @return
     */
    @Value("${mq.pay.exchange.order}")
    private String exchange;
    @Value("${mq.pay.queue.order}")
    private String queue;
    @Value("${mq.pay.routing.key}")
    private String routing;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping(value = "/notify/url")
    public String notifyUrl(HttpServletRequest request){
        try {
            InputStream inStream = request.getInputStream();
            String result = IOUtils.toString(inStream,"UTF-8");
            Map <String, String> map = WXPayUtil.xmlToMap(result);
            System.out.println(map);
            //读取附加消息-交换机与队列
            Map<String,String> attachMap = JSON.parseObject(map.get("attach"), Map.class);
            exchange = attachMap.get("exchange");
            routing = attachMap.get("routingKey");

            rabbitTemplate.convertAndSend(exchange,routing, JSON.toJSONString(map));
            Map respMap = new HashMap();
            respMap.put("return_code","SUCCESS");
            respMap.put("return_msg","OK");
            return WXPayUtil.mapToXml(respMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("createSeckillQueue")
    public String createSeckillQueue(){
        rabbitTemplate.convertAndSend("exchange.order","queue.seckillorder","{'flag':'ok'}");
        return "ok";
    }
    @RequestMapping("/weixin/pay")
    public interface WeixinPayFeign {
        @RequestMapping("/closePay")
        Map<String,String> closePay(Long orderId) throws Exception;
    }

}
