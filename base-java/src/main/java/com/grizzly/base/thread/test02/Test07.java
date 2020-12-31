package com.grizzly.base.thread.test02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test07 {

    static int r = 1;


    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    public static void test1() throws InterruptedException {
        log.info("开始");
        Thread t1 = new Thread(() -> {
            log.info("开始");
            try {

                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("结束");
            r = 10;
        });

        t1.start();
            t1.join(); //等待t1执行完毕

        log.info("结果为:{}" ,r);
        log.info("结束");
    }
}
