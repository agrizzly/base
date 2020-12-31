package com.grizzly.base.thread.test06;

import lombok.extern.slf4j.Slf4j;


/**
 * 线程八锁
 * */
@Slf4j
public class Test2 {

    public synchronized  void a() throws InterruptedException {
        Thread.sleep(1000);
        log.info("1");
    }

    public synchronized  void b(){
        log.info("2");
    }

    public static void main(String[] args) {
        Test2 test = new Test2();
        new Thread(()->{
            log.info("begin");
            try {
                test.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            log.info("begin");
            test.b(); }).start();
    }
}


