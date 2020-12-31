package com.grizzly.base.thread.test02;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test01 {

    public static void main(String[] args) {

        new Thread(() -> {
            while (true){
                log.info("running");
            }
        },"t1").start();

        new Thread(() -> {
            while (true){
                log.info("running");
            }
        },"t2").start();
    }
}
