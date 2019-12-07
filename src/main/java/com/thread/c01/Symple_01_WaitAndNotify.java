package com.thread.c01;

/**
 * jh
 * 2019年12月05日  21：15
 */
public class Symple_01_WaitAndNotify {
    public static Object object = new Object();
    public static class T1 extends Thread{
        @Override
        public void run(){
            synchronized (object){
                System.out.println(System.currentTimeMillis()+":T1 run");
                try {
                    System.out.println(System.currentTimeMillis()+":T1 wait for object");
                    object.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+":T1 end");
            }
        }
    }


    public static class T2 extends Thread{
        @Override
        public void run(){
            synchronized (object){
                System.out.println(System.currentTimeMillis()+":T2 started,notify 1 thread");
                try {
                object.notify();
                System.out.println(System.currentTimeMillis()+":T2 end");

                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }





}