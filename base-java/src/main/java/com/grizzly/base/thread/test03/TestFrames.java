package com.grizzly.base.thread.test03;

/*
* debug查看栈帧
* */
public class TestFrames {

    public static void main(String[] args) {

        new Thread(() -> {
            method1(20);
        },"t1").start();
        method1(10);
    }

    public static void method1(int x){
        int y = x + 1;
        Object m = method2();
    }

    public static Object method2(){
        Object object = new Object();
        return object;
    }
}
