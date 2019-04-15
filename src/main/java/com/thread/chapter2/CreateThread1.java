package com.thread.chapter2;


/**
 * jh
 * 2019年04月14日  14：53
 * 继承Thread方式创建线程
 */
public class CreateThread1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("hello,I'm t1");
            }
        };
        t1.start();

    }
}