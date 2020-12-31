package com.grizzly.base.thread.test05;

import lombok.extern.slf4j.Slf4j;

/**
 * synchronized
 * */
@Slf4j
public class Test3 {

    static int count = 0;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            for (int i=0;i<5;i++){
                log.info("t1加锁");
                synchronized (lock){
                    count++;
                }
            }
        },"t1");

        Thread t2 = new Thread(() -> {
            for (int i=0;i<5;i++){
                log.info("t2加锁");
                synchronized (lock){
                    count--;
                }
            }
        },"t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("{}",count);
    }

}
