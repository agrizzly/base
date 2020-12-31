package com.grizzly.base.thread.test02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test08 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted){
                    log.info("被打断");
                    break;
                }
            }
        },"t1");

        t1.start();

        Thread.sleep(100);

        log.info("interrupted");
        t1.interrupt();
    }
}
