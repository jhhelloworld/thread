package com.thread.chapter2;

/**
 * jh
 * 2019年04月14日  01：07
 * stop方法强行终止线程造成数据不一致问题
 */
public class StopThreadUnsafe {
    private static User u = new User();
    //操作对象
    public static class User{
        private int id;
        private String name;

        public User() {
            this.id = 0;
            this.name = "0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "user [id="+id+", name="+name+"]";
        }
    }

    public static class ChangeObjectThread extends Thread{
        @Override
        public void run() {
            synchronized (u){
                while (true){
                    int v = (int)System.currentTimeMillis()/1000;
                    u.setId(v);
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                    Thread.yield();
                }
            }
        }
    }

    public static class ReadObjectThread extends Thread{
        @Override
        public void run(){
            while (true){
                synchronized (u){
                    if(u.getId()!=Integer.parseInt(u.getName())){
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true){
            Thread t1 = new ChangeObjectThread();
            t1.start();
            Thread.sleep(150);
            t1.stop();
        }
    }


}