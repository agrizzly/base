package com.grizzly.base.thread.test01;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test03 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> log.info("running"));
        thread.setName("test");
        thread.start();
        log.info("running");
    }
}
