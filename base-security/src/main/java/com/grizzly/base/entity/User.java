package com.grizzly.base.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private String id;
    private String username;
    private String password;
    private List<String> roles;

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String id, String username, String password, List<String> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
