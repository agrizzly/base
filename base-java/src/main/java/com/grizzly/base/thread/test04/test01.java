package com.grizzly.base.thread.test04;


import lombok.extern.slf4j.Slf4j;

/**
 * 守护线程
 * */
@Slf4j
public class test01 {

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            log.info("结束");
        }, "t1");

        t1.setDaemon(true);
        t1.start();

        Thread.sleep(1000);
        log.info("结束");
    }
}
