package com.grizzly.base.thread.test03;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class Test03 {

    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    public static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.info("park...");
            LockSupport.park();
            log.info("unpark...");
            log.info("打断状态: {}",Thread.currentThread().isInterrupted());
        }, "t1");

        t1.start();

        Thread.sleep(1000);
        t1.interrupt();
    }

}
