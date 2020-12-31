package com.grizzly.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @RequestMapping("/login")
    public String hello(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
