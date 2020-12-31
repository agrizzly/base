package com.grizzly.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.grizzly.base.entity.User;
import com.grizzly.base.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VueElementApplicationTest {

    @Resource
    private UserMapper userMapper;


    /**
     * 模糊查询
     * */
    @Test
    public void selectByWrapper1(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

}