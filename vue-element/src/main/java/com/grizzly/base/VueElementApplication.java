package com.grizzly.base;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.grizzly.base.mapper")
public class VueElementApplication {
    public static void main(String[] args) {
        SpringApplication.run(VueElementApplication.class,args);
    }
}
