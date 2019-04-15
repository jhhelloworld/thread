package com.thread.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * jh
 * 2019年04月14日  23：45
 */
public class SemaphoreDemo implements Runnable{
    final Semaphore semp = new Semaphore(2);
    static  int ii = 0;
    @Override
    public void run(){
        try {
            semp.acquire();
            for(int i = 0;i<10000;i++){
                ii = ii+1;
            }
            semp.release();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        final SemaphoreDemo demo = new SemaphoreDemo();
        for(int i = 0;i<2;i++){
            exec.submit(demo);
        }
        Thread.sleep(5000);
        System.out.println(ii);
    }
}