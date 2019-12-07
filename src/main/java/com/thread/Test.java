package com.thread;

/**
 * jh
 * 2019年12月05日  17：59
 */
public class Test {

    public static void main(String[] args) {
        Thread thread = new Thread(){
          @Override
          public void run(){
              System.out.println("test");
          }
        };
        thread.start();
    }

}