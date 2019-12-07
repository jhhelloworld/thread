package com.thread.chapter2;


/**
 * jh
 * 2019年04月14日  14：53
 * 继承Thread方式创建线程
 */
public class CreateThread1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("is interrupted");
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted when sleep");
                        //设置中断状态
                        //Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();


    }
}