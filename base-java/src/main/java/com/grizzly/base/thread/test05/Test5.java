package com.grizzly.base.thread.test05;

import lombok.extern.slf4j.Slf4j;

/**
 * synchronized
 * */
@Slf4j
public class Test5 {


    public static void main(String[] args) throws InterruptedException {

        Room room = new Room();

        Thread t1 = new Thread(() -> {
                for (int i=0;i<10;i++){
                    log.info("t1加锁");
                    room.add();
                    log.info("{}",room.getCount());
                }
        },"t1");

        Thread t2 = new Thread(() -> {
                for (int i=0;i<10;i++){
                    log.info("t2加锁");
                    room.sub();
                    log.info("{}",room.getCount());
                }
        },"t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("{}",room.getCount());
    }
}

class Room {
    private int count = 0;

    public void add(){
        synchronized (this){
            count ++;
        }
    }

    public void sub(){
        synchronized (this){
            count --;
        }
    }

    public int getCount(){
        synchronized (this){
            return count;
        }
    }
}
