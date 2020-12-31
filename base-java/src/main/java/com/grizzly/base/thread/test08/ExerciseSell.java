package com.grizzly.base.thread.test08;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

@Slf4j
public class ExerciseSell {

    public static void main(String[] args) throws InterruptedException {

        TicketWindows ticketWindows = new TicketWindows(1000);

        List<Thread> threadList = new ArrayList<>();

        List<Integer> list = new Vector<>();

        for (int i=0;i<2000;i++){
            Thread thread = new Thread(()->{
                try {
                    Thread.sleep(random(5));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int amount = ticketWindows.sell(random(5));
                list.add(amount);
            });
            threadList.add(thread);
                    thread.start();
        }

        for(Thread t : threadList) {
            t.join();
        }

        log.info("余票数量{}张",ticketWindows.getCount());
        log.info("卖出数量{}张",list.stream().mapToInt(t -> t).sum());
    }

    // Random 为线程安全
    static Random random = new Random();

    // 随机 1~5
    public static int random(int amount) {
        return random.nextInt(amount) + 1;
    }
}


class TicketWindows{

    private int count;

    public TicketWindows(int count){
        this.count = count;
    }
    // 获取余票数量
    public int getCount() {
        return count;
    }

    // 售票
    public int sell(int amount) {
        if (this.count >= amount) {
            this.count -= amount;
            return amount;
        } else {
            return 0;
        }
    }
}