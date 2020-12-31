package com.grizzly.base.thread.test06;

import lombok.extern.slf4j.Slf4j;


/**
 * 线程八锁
 * */
@Slf4j
public class Test4 {

    public synchronized  void a() throws InterruptedException {
        Thread.sleep(1000);
        log.info("1");
    }

    public synchronized  void b(){
        log.info("2");
    }

    public static void main(String[] args) {
        Test4 test1 = new Test4();
        Test4 test2 = new Test4();
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


