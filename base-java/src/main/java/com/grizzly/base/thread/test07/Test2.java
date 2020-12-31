package com.grizzly.base.thread.test07;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    static final int THREAD_NUMBER = 2;
    static final int LOOP_NUMBER = 200;

    public static void main(String[] args) {
        UnSafeThread unSafeThread = new UnSafeThread();

        // 引用的是同一个对象的成员变量
        for (int i=0;i<THREAD_NUMBER;i++){
            new Thread(()->{
                unSafeThread.method1(LOOP_NUMBER);

            },"Thread" + (i+1)).start();
        }
    }
}

/**
 * 非线程安全
 * */
class UnSafeThread{
    List<String> list = new ArrayList<>();

    public void method1(int loopNumber){
        for (int i=0;i<loopNumber;i++){
            method2();
            method3();
        }
    }

    private void method2(){
        list.add("1");
    }

    private void method3(){
        list.remove(0);
    }
}
