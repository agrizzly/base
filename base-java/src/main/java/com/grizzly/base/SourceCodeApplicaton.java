package com.grizzly.base;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SourceCodeApplicaton {

    public static void main(String[] args) {
        SpringApplication.run(SourceCodeApplicaton.class,args);
    }

    @Bean
    public void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setBeanName("AopAutoConfiguration");
    }
}
