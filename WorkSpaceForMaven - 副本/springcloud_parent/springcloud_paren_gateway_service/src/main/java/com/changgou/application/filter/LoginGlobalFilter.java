package com.itheima.application.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class LoginGlobalFilter implements GlobalFilter, Ordered {
    /***
     * 过滤拦截
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求参数token
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        //如果没有传入token
//        if (StringUtils.isEmpty(token)) {
//            //设置返回状态码-400参数异常
//            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
//            //结束请求
//            return exchange.getResponse().setComplete();
//        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
