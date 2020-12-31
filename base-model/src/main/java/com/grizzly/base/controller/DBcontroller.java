package com.grizzly.base.controller;

import com.grizzly.base.entity.User;
import com.grizzly.base.mapper.UserMapper;
import com.grizzly.base.service.DBservice;
import com.grizzly.base.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class DBcontroller {

    @Autowired
    private DBservice dBservice;

    @Resource
    private UserMapper userMapper;

    @PostMapping(value = "/user")
    public Result saveUser(@RequestBody User user){
        System.out.println(user.toString());
        return Result.success(userMapper.insert(user));
    }

    @DeleteMapping(value = "/user/{id}")
    public Result deleteUser(@PathVariable("id") Integer id){
        return Result.success(userMapper.deleteById(id));
    }

    @PutMapping(value = "/user/{id}")
    public Result updateUser(@PathVariable("id") Integer id,@RequestBody User user){
        System.out.println(user.toString());
        return Result.success(userMapper.updateById(user));
    }

    @GetMapping(value = "/user")
    public Result getUser(){
        return Result.success(userMapper.selectList(null));
    }

    @GetMapping(value = "/user/{id}")
    public Result getUser(@PathVariable("id") Integer id){
        return Result.success(userMapper.selectById(id));
    }
}
