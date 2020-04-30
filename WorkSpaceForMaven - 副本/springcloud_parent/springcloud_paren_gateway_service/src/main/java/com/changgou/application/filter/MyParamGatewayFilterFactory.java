package com.itheima.application.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import sun.plugin.javascript.navig.Array;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Component
public class MyParamGatewayFilterFactory extends AbstractGatewayFilterFactory<MyParamGatewayFilterFactory.Config> {
    /***
     * 构造函数
     */
    public MyParamGatewayFilterFactory() {
        super(MyParamGatewayFilterFactory.Config.class);
    }
    /**
     * 定义需要处理的参数
     */
    public static final String PARAM_NAME = "name";
    /****
     * 处理过程
     * @return
     */
    @Override
    public GatewayFilter apply(MyParamGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                String name = exchange.getRequest().getQueryParams().getFirst("name");
                if(!StringUtils.isEmpty(name)){
                    System.out.println("名字参数："+name);
                }
                return chain.filter(exchange);
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAM_NAME);
    }
    /****
     * 需要处理的参数
     * name：和处理的参数名字保持一致
     */
    public static class Config {
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
