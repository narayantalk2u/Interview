package com.example.thread.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class LogWriter implements Runnable{
    private Thread thread;
    private String threadName;
    private BlockingQueue<LogDetails> sharedQueue;
    ThreadGroup threadGroup;

    public LogWriter(ThreadGroup tg,BlockingQueue<LogDetails> sharedQueue,String threadName) {
        System.out.println("Producer: ");
        this.threadName = threadName;
        this.sharedQueue = sharedQueue;
        threadGroup = tg;
    }

    @Override
    public void run() {
     //   for (int i = 0; i < 10; i++) {
        PrintWriter fileWriter = null;
            try {
                fileWriter = new PrintWriter(new File("commitlog.txt"));
                LogDetails logDetails = new LogDetails(threadName,"Data from Thread ","Writer1");
                fileWriter.print(logDetails.toString());
                logDetails.incrementCount();

                System.out.println(thread.getName() + " produced ");
                sharedQueue.put(logDetails);
                Thread.sleep(200);
            } catch (InterruptedException | FileNotFoundException e) {
                e.printStackTrace();
            }finally{
                fileWriter.close();
            }
     //   }
    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if(thread == null){
            thread = new Thread(threadGroup,this,threadName);
        }
        thread.start();
    }
}
