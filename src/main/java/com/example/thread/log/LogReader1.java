package com.example.thread.log;

import java.io.*;
import java.util.concurrent.BlockingQueue;

public class LogReader1 implements Runnable{
    private Thread thread;
    private String threadName;
    private BlockingQueue<LogDetails> sharedQueue;
    private ThreadGroup threadGroup;

    public LogReader1(ThreadGroup tg,BlockingQueue<LogDetails> sharedQueue, String threadName) {
        System.out.println("Consumer: ");
        this.threadName = threadName;
        this.sharedQueue = sharedQueue;
        threadGroup = tg;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            //while (true) {
            br = new BufferedReader(new FileReader(new File("./commitlog.txt")));
            LogDetails item = sharedQueue.take();
            System.out.println(thread.getName() + " consumed " + item);
            System.out.println("Before decrement: "+item.getAtomicInteger().get());
            item.decrementCount();
            System.out.println("After decrement: "+item.getAtomicInteger().get());
            if (item.getAtomicInteger().get() > 0) {
                sharedQueue.put(item);
            }
            //}
        } catch (InterruptedException | FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if(thread == null){
            thread = new Thread(threadGroup,this,threadName);
        }
        thread.start();
    }
}
