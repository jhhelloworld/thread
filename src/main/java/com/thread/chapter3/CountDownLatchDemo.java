package com.thread.chapter3;

import oracle.jvm.hotspot.jfr.TraceTypes;

import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * jh
 * 2019年04月15日  12：48
 */
public class CountDownLatchDemo implements Runnable{
    //生产CountDownLatch实例，需要有10个线程完成任务
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();
    @Override
    public void run() {
        try {
            //模拟检查任务
            Thread.sleep(new Random().nextInt(10)*100);
            System.out.println("check complete!");
            end.countDown();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for(int i = 0;i< 10;i++){
            exec.submit(demo);
        }
        //等待检查，主线程的操作就会在这个方法上阻塞，直到其他线程完成各自的任务。
        end.await();
        //发射火箭
        System.out.println("Fire!");
        exec.shutdown();
    }
}