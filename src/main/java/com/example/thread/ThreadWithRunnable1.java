package com.example.thread;

public class ThreadWithRunnable1 implements Runnable {
    private Thread thread;
    private String threadName;

    public ThreadWithRunnable1(String threadName){
        this.threadName = threadName;
        System.out.println("Creating " +  threadName );
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println(threadName + ", " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted.");
        }
        System.out.println(threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if(thread == null){
            thread = new Thread(this,threadName);
            thread.start();
        }
    }
}
