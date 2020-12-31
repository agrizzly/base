package com.grizzly.base.common.security;

import com.grizzly.base.common.JWT.JwtUserFactory;
import com.grizzly.base.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List list = new ArrayList();
        list.add("ROLE_ADMIN");
        User user = new User("1", "wxf", "1234", list);
        UserDetails userDetails = JwtUserFactory.create(user);
        if (username.isEmpty()) {
            throw new UsernameNotFoundException("不存在该用户!");
        }
        return userDetails;
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
