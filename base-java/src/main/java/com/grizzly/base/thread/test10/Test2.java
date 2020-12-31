package com.grizzly.base.thread.test10;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class Test2 {

    static boolean flag = true;
    public static void main(String[] args) {

        new Thread(()->{
            while (flag){
                log.info("test");
            }
        }).start();

        log.info("停止");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
    }
}
