package com.grizzly.base.thread.test09;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBiased {

    public static void main(String[] args) {

        Object object = new Object();

        new Thread(()->{
            log.info("t1 1");
            synchronized (object){
                log.info("t1 2");
            }
            log.info("t1 3");

            synchronized (TestBiased.class){
                TestBiased.class.notify();
            }
        },"t1").start();

        new Thread(()->{

            synchronized (TestBiased.class){
                    try {
                        TestBiased.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
            log.info("t2 1");
            synchronized (object){
                log.info("t2 2");
            }
            log.info("t2 3");
        },"t2").start();
    }
}
