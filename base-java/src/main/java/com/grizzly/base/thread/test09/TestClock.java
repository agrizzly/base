package com.grizzly.base.thread.test09;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestClock {

    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();

        new Thread(() -> {
            synchronized (A){
                log.info("lock A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    log.info("lock B");
                    log.info("B 操作");
                }
            }
        },"A").start();

        new Thread(() -> {
            synchronized (B){
                log.info("lock B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A){
                    log.info("lock A");
                    log.info("A 操作");
                }
            }
        },"B").start();
    }
}
