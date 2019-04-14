package com.thread.chapter2;

/**
 * jh
 * 2019年04月14日  01：07
 */
public class StopThreadUnsafe {
    private static User u = new User();
    public static class User{
        private int id;
        private String name;

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
    }
}