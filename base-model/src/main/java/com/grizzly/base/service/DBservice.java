package com.grizzly.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.grizzly.base.entity.User;

import java.util.List;

public interface DBservice extends IService<User> {

    List<User> getAll();
}
