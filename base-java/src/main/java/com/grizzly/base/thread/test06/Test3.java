package com.grizzly.base.thread.test06;

import lombok.extern.slf4j.Slf4j;


/**
 * 线程八锁
 * */
@Slf4j
public class Test3 {

    public synchronized  void a() throws InterruptedException {
        Thread.sleep(1000);
        log.info("1");
    }

    public synchronized  void b(){
        log.info("2");
    }

    public void c(){
        log.info("3");
    }

    public static void main(String[] args) {
        Test3 test = new Test3();
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

        new Thread(()->{
            log.info("begin");
            test.c(); }).start();
    }
}


