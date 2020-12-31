package com.grizzly.base.thread.test02;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Test05 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            log.info("enter sleep");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                log.info("wake up");
                e.printStackTrace();
            }
        });

        thread.start();

        try {
            Thread.sleep(1000);
//            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("interrupt");
        thread.interrupt();


    }
}
