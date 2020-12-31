package com.grizzly.base.thread.test02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test02 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            log.info("running");
        });

        /**
         * 通过run方法执行还是在main线程中执行,不能达到异步的作用
         * */
//        thread.run(); //14:36:30.452 [main] INFO com.grizzly.base.thread.test02.Test02 - running
        thread.start(); //14:36:52.047 [Thread-0] INFO com.grizzly.base.thread.test02.Test02 - running
    }
}
