package com.changgou.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtils {
    private static JedisPoolConfig poolConfig;
    private static JedisPool jedisPool;
    static {
         poolConfig = new JedisPoolConfig();
         poolConfig.setMaxTotal(10);
         String host="localhost";
         int port=6379;
         jedisPool = new JedisPool(poolConfig, host, port);
    }

    public JedisUtils() {
    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
