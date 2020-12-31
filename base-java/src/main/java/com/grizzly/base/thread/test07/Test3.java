package com.grizzly.base.thread.test07;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

    static final int THREAD_NUMBER = 2;
    static final int LOOP_NUMBER = 200;

    public static void main(String[] args) {
        SafeThread unSafeThread = new SafeThread();


        for (int i=0;i<THREAD_NUMBER;i++){
            new Thread(()->{
                unSafeThread.method1(LOOP_NUMBER);

            },"Thread" + (i+1)).start();
        }
    }
}

/**
 * 线程安全
 * */
class SafeThread{


    public void method1(int loopNumber){
        List<String> list = new ArrayList<>();

        for (int i=0;i<loopNumber;i++){
            method2(list);
            method3(list);
        }
    }

    private void method2(List<String> list){
        list.add("1");
    }

    private void method3(List list){
        list.remove(0);
    }
}
