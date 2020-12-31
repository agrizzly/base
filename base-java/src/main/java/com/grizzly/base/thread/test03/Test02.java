package com.grizzly.base.thread.test03;

import lombok.extern.slf4j.Slf4j;

/**
 * 两阶段终止模式
 * */
public class Test02 {

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();

        Thread.sleep(3500);
        twoPhaseTermination.stop();
    }
}


@Slf4j
class TwoPhaseTermination {
    private Thread monitor;

    public void start(){
        monitor = new Thread(() -> {
            while (true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted){
                    log.info("料理后事");
                    break;
                }else{
                    try {
                        Thread.sleep(1000);
                        log.info("监控");
                    } catch (InterruptedException e) { //被打断isInterrupted会被置为false
                        e.printStackTrace();
                        Thread.currentThread().interrupt(); //重新设置打断标记使程序在下次循环中终止
                    }
                }
            }
        });
        monitor.start();
    }

    public void stop(){
        monitor.interrupt();
    }
}
