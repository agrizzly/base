package com.grizzly.base.thread.test02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test03 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            log.info("running");
        });

        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
    }
}
