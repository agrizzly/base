package com.grizzly.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.grizzly.base.entity.User;
import com.grizzly.base.mapper.UserMapper;
import com.grizzly.base.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @PostMapping(value = "/login")
    public JSONObject login(String username, String password){
        System.out.println(username);
        System.out.println(password);
        if("admin".equals(username) && "123456".equals(password)){
            JSONObject data = new JSONObject();
            data.put("token","abcdefg");
            return Result.success(data);
        }else{
            return Result.fail("用户名或密码错误");
        }
    }

//    @PostMapping(value = "/login")
//    public JSONObject login(@RequestBody LinkedHashMap<String,String> params){
//        String username = params.get("username");;
//        System.out.println(username);
////        System.out.println(password);
//        System.out.println("登录");
//        return null;
//    }

    @GetMapping(value = "/info")
    public Result info(String token){
        System.out.println("info");
        System.out.println(token);
        JSONObject data = new JSONObject();
        data.put("name","wxf");
        data.put("avatar","grizzly");
        return Result.success(data);
    }

    @PostMapping(value = "/logout")
    public Result logout(String token){
        System.out.println("logout");
        System.out.println(token);
        return Result.success(true);
    }

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
