package com.example.thread.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private Thread thread;
    private String threadName;
    private BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue,String threadName) {
        System.out.println("Producer: ");
        this.threadName = threadName;
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(thread.getName() + " produced " + i);
                sharedQueue.put(i);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
