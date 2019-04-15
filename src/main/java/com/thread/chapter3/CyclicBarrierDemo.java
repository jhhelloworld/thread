package com.thread.chapter3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * jh
 * 2019年04月15日  12：42
 */
public class CyclicBarrierDemo {
    public static class Soldier implements Runnable{
        private String soldier;
        private final CyclicBarrier cyclic;

        public Soldier(CyclicBarrier cyclic,String soldier) {
            this.soldier = soldier;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
                //等待所有士兵到齐
                cyclic.await();
                doWork();
                cyclic.await();

            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (BrokenBarrierException e){
                e.printStackTrace();
            }

        }
        void doWork(){
            try {
                Thread.sleep(new Random().nextInt(10)*100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(soldier+":任务完成");
        }
    }
    public static class  BarrierRun implements Runnable{
        boolean flag;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }
        @Override
        public void run(){
            if(flag){
                System.out.println("司令：【士兵"+N+"个，任务完成");
            }else {
                System.out.println("司令：【士兵"+N+"个，集合完毕");
                flag = true;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        final int N =10;
        Thread[] allSolider = new Thread[10];
        boolean flag = false;
        //每次计数器达到指标，执行BarrierRun 方法
        CyclicBarrier cyclic = new CyclicBarrier(N,new BarrierRun(flag,N));
        //设置屏障点，主要是为了执行这个方法
        System.out.println("集合队伍！");
        for(int i = 0;i<N;i++){
            System.out.println("士兵"+i+" 报道");
            allSolider[i] = new Thread(new Soldier(cyclic,"士兵"+i));
            allSolider[i].start();
        }
    }

}