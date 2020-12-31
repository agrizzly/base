package com.grizzly.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/setredis")
    public String setRedis(){
        redisTemplate.opsForValue().set("user","wxf");
        return null;
    }

}
