package com.thread.chapter2;

/**
 * jh
 * 2019年04月14日  14：57
 * 实现Runable接口
 */
public class CreateThread2 implements Runnable{
    public static void main(String[] args) {
        Thread t1 = new Thread(new CreateThread2());
        t1.start();
    }

    @Override
    public void run() {
        System.out.println("Oh,I'm Runable");
    }
}