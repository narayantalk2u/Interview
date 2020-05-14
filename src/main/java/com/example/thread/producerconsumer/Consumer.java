package com.example.thread.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private Thread thread;
    private String threadName;
    private BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue,String threadName) {
        System.out.println("Consumer: ");
        this.threadName = threadName;
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = sharedQueue.take();
                System.out.println(thread.getName() + " consumed " + item);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if(thread == null){
            thread = new Thread(this,threadName);
        }
        thread.start();
    }
}
