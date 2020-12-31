package com.grizzly.base.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author DurantSimpson
 * @desc JSON对象管理器
 * @create 2018-05-09 19:02
 **/
public class Result extends JSONObject {

    /**
     * 创建新的成功JSON对象
     * @param object 状态
     * @return JSON对象
     */
    public static Result success(Object object){
        return newInstance(200,"成功",object);
    }

    /**
     * 创建新的成功JSON对象
     * @param message 成功信息
     * @param object 状态
     * @return JSON对象
     */
    public static Result success(String message, Object object){
        return newInstance(200, message, object);
    }

    /**
     * 创建新的成功JSON对象
     * @param message 成功信息
     * @return JSON对象
     */
    public static Result success(String message){
        return newInstance(200, message);
    }

    /**
     * 创建新的成功JSON对象
     * @return JSON对象
     */
    public static Result success(){
        return newInstance(200,"成功");
    }

    /**
     * 创建新的失败JSON对象
     * @param message 失败信息
     * @return JSON对象
     */
    public static Result fail(String message){
        return newInstance(500, message);
    }

    /**
     * 创建新的失败JSON对象
     * @return JSON对象
     * @param b
     */
    public static Result fail(boolean b){
        return newInstance(500, "失败");
    }

    /**
     * 创建新的JSON对象
     * @param code 状态
     * @param message 信息
     * @param object 内容
     * @return JSON对象
     */
    public static Result newInstance(Integer code, String message, Object object){
        Result result = new Result();
        result.put("code",code);
        result.put("message",message);
        result.put("data",object);
        return result;
    }

    /**
     * 创建新的JSON对象
     * @param code 状态
     * @param message 信息
     * @return JSON对象
     */
    public static Result newInstance(Integer code, String message){
        Result result = new Result();
        result.put("code",code);
        result.put("message",message);
        return result;
    }
}
