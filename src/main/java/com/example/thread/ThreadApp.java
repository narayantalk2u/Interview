package com.example.thread;

public class ThreadApp {
    public static void main(String[] args) {
        ThreadWithRunnable1 t1 = new ThreadWithRunnable1("Thread-1");
        t1.start();

        ThreadWithRunnable1 t2 = new ThreadWithRunnable1("Thread-2");
        t2.start();
    }

}
