package com.grizzly.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.grizzly.base.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {

}