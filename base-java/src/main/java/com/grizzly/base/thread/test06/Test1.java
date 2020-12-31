package com.grizzly.base.thread.test06;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程八锁
 * */
@Slf4j
public class Test1 {

    public synchronized  void a(){
        log.info("1");
    }

    public synchronized  void b(){
        log.info("2");
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        new Thread(()->{
            log.info("begin");
            test1.a(); }).start();
        new Thread(()->{
            log.info("begin");
            test1.b(); }).start();
    }
}


