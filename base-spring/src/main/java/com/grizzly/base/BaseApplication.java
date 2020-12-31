package com.grizzly.base;

import com.grizzly.base.annotation.scan.HelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BaseApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(BaseApplication.class, args);

        HelloWorld helloWord = applicationContext.getBean("helloWorld", HelloWorld.class);
        System.out.println(helloWord.say());
    }

}
