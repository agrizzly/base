package com.grizzly.base.thread.test05;

import lombok.extern.slf4j.Slf4j;

/**
 * 烧水泡茶
 * */
@Slf4j
public class Test1 {

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            log.info("洗水壶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("烧开水");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"小王");

        Thread t2 = new Thread(() -> {
            log.info("洗茶壶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("洗茶杯");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("拿茶叶");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("泡茶");
        },"老王");

        t1.start();
        t2.start();
    }

}
