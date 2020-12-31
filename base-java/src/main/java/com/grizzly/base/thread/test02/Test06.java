package com.grizzly.base.thread.test02;


import lombok.extern.slf4j.Slf4j;

public class Test06 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {

            int count = 0;
            while (true){
//                Thread.yield();
                System.out.println("->>>t1" + count++);
            }
        });


        Thread t2 = new Thread(() -> {
            int count = 0;
            while (true){
//                Thread.yield();
                System.out.println("            ->>>t2" + count++);
            }
        });

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}
