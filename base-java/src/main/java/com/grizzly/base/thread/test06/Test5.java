package com.grizzly.base.thread.test06;

import lombok.extern.slf4j.Slf4j;


/**
 * 线程八锁
 * */
@Slf4j
public class Test5 {

    // 锁住类
    public static synchronized  void a() throws InterruptedException {
        Thread.sleep(1000);
        log.info("1");
    }

    // 锁住对象
    public synchronized  void b(){
        log.info("2");
    }
    /**
     * 等价于
     * public  void b(){
     *  synchronized(this)
     *         log.info("2");
     *     }
     *  }
     * */

    // 由于锁住的不是同一个对象,所以不是互斥,先输出2再输出1
    public static void main(String[] args) {
        Test5 test = new Test5();
        new Thread(()->{
            log.info("begin");
            try {
                test.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            log.info("begin");
            test.b(); }).start();
    }
}


