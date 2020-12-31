package com.grizzly.base.thread.test06;

import lombok.extern.slf4j.Slf4j;


/**
 * 线程八锁
 * */
@Slf4j
public class Test8 {

    public static synchronized  void a() throws InterruptedException {
        Thread.sleep(1000);
        log.info("1");
    }

    public static synchronized  void b(){
        log.info("2");
    }

    public static void main(String[] args) {
        Test8 test1 = new Test8();
        Test8 test2 = new Test8();
        new Thread(()->{
            log.info("begin");
            try {
                test1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            log.info("begin");
            test2.b(); }).start();
    }
}


