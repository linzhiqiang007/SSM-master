package com.fuzhu.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private static Jedis jedis = new Jedis("192.168.17.128");

    @RequestMapping(value = "/findRedisName", produces = "text/html;charset=UTF-8", method = {RequestMethod.GET, RequestMethod.GET})
    public Object findRedisName(String key, String value, HttpServletResponse response) throws Exception {
        Map<String, String> StringMap = new HashMap<String, String>();
        if (!value.equals(jedis.get(key))){
            String set = jedis.set(key,value);
            if ("OK".equals(set)) {
                StringMap.put("code", "1");
                StringMap.put("start", "成功");
            } else {
                StringMap.put("code", "0");
                StringMap.put("start", "失败");
            }
        }else {
            StringMap.put("code", "9");
            StringMap.put("start", "抱歉不能在同一个key中输入相同的内容！！！");
        }
        return JSON.toJSONString(StringMap);
    }
}
