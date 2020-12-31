package com.grizzly.base.service.Impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.grizzly.base.entity.User;
import com.grizzly.base.mapper.UserMapper;
import com.grizzly.base.service.DBservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBserviceImpl extends ServiceImpl<UserMapper,User> implements DBservice {

    @Autowired
    private UserMapper userMapper;

    @Override
    @DS("slave_1")
    public List<User> getAll() {
        return userMapper.selectList(null);
    }
}
