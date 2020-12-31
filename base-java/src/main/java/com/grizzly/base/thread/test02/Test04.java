package com.grizzly.base.thread.test02;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test04 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        log.info(" thread state: {}",thread.getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(" thread state: {}",thread.getState());
    }
}
