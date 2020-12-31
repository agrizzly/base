package com.grizzly.base.thread.test01;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class Test04 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.info("running");
                Thread.sleep(2000);
                return 100;
            }
        });

        Thread thread = new Thread(integerFutureTask,"test");

        thread.start();

        log.info("{}",integerFutureTask.get());
    }
}
