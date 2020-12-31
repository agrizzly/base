package com.grizzly.base.test1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

public class AppTest {
    public static void main(String[] args) {
        StopWatch clock = new StopWatch();
        clock.start("开始任务");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Boy boy = context.getBean("boy",Boy.class);
        Girl girl = (Girl) context.getBean("girl");
        boy.buy(20);
        girl.buy(60);
        clock.stop();

        System.out.println(clock.prettyPrint());

    }
}
