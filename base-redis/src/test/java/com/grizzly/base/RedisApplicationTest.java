package com.grizzly.base;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grizzly.base.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class RedisApplicationTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws JsonProcessingException {
        User user = new User(1, "aaa", "123456");
        String str = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("abs",str);
        System.out.println(redisTemplate.opsForValue().get("abs"));
    }

}