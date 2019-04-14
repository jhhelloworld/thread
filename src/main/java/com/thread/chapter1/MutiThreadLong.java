package com.thread.chapter1;

/**
 * jh
 * 2019年04月14日  13：41
 * 验证32位操作系统，long型的读写不是原子性的
 */
public class MutiThreadLong {
    public static long t = 0;


    public static class changT implements Runnable {
        private long to;
        public changT(long to) {
            this.to = to;
        }

        @Override
        public void run() {
            while (true) {
                MutiThreadLong.t = to;
                Thread.yield();
            }
        }
    }

    public static class ReadT implements Runnable {
        @Override
        public void run() {
            while (true) {
                long tmp = MutiThreadLong.t;
                if (tmp != 111L && tmp != -999L && tmp != 333L && tmp != -444L) {
                    System.out.println(tmp);
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new changT(111L)).start();
        new Thread(new changT(-999L)).start();
        new Thread(new changT(333L)).start();
        new Thread(new changT(-444L)).start();
        new Thread(new ReadT()).start();

    }


}