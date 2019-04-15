package com.thread.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * jh
 * 2019年04月15日  15：27
 */
public class ThreadPoolDemo {
    public static class Mytask implements Runnable{
        @Override
        public void run(){
            System.out.println(System.currentTimeMillis()+":ThreadId:"+Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Mytask mytask = new Mytask();
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i = 0;i<10;i++){
            es.submit(mytask);
        }
    }
}