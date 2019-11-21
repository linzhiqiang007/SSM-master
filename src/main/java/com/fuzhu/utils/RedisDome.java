package com.fuzhu.utils;

import redis.clients.jedis.Jedis;

public class RedisDome {
    public static void main(String[] args) {
        RedisUtil redisUtil = new RedisUtil();
        String key = "wang";
        String value = "123456";
        //boolean set = redisUtil.set(key, value);
        Jedis jedis = new Jedis("192.168.17.128");
        if (value.equals(jedis.get(key))){
            System.out.println("写入不成功，key值已存在");
        }else {
            String set = jedis.set(key, value);
            System.out.println(set);
            if ("OK".equals(set)) {
                System.out.println("写入成功！！！");
            } else {
                System.out.println("写入失败！！！");
            }
        }
    }
}
