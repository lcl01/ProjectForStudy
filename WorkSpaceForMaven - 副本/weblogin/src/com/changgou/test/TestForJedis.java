package com.changgou.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class TestForJedis {
    @Test
    public void fun01(){
        String host="localhost";
        int port=6379;
        Jedis jedis = new Jedis(host, port);
        jedis.select(1);
        HashMap<String, String> hash = new HashMap<>();
        hash.put("name","jac");
        hash.put("address","dfs");
        jedis.hmset("b",hash);
        jedis.set("s","xixix");
        System.out.println(jedis.get("s"));
        System.out.println(jedis.hmget("b","name"));
        jedis.close();
    }
    @Test
    public void fun02(){

        Jedis jedis = new Jedis("localhost", 6379);
        jedis.select(1);
        jedis.del("b");
        jedis.del("s");
        jedis.close();

    }
}
