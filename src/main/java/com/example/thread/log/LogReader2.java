package com.example.thread.log;

import java.util.concurrent.BlockingQueue;

public class LogReader2 implements Runnable{
    private Thread thread;
    private String threadName;
    private BlockingQueue<LogDetails> sharedQueue;

    public LogReader2(BlockingQueue<LogDetails> sharedQueue, String threadName) {
        System.out.println("Consumer: ");
        this.threadName = threadName;
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        try {
            LogDetails item = sharedQueue.take();
            System.out.println(thread.getName() + " consumed " + item);
            System.out.println("Before decrement: "+item.getAtomicInteger().get());
            item.decrementCount();
            System.out.println("After decrement: "+item.getAtomicInteger().get());
            if (item.getAtomicInteger().get() != 0) {
                sharedQueue.put(item);
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
