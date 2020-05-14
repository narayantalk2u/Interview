package com.example.thread.log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LoggerApp {
    public static void main(String[] args) {
        BlockingQueue<LogDetails> sharedQ = new LinkedBlockingQueue<LogDetails>();
        ThreadGroup writerGroup = new ThreadGroup("A");
        ThreadGroup readerGroup = new ThreadGroup("B");
        LogWriter writer1 = new LogWriter(writerGroup,sharedQ,"Writer_1");
        LogWriter writer2 = new LogWriter(writerGroup,sharedQ,"Writer_2");

        LogReader1 reader1 = new LogReader1(readerGroup,sharedQ,"Reader1");
        LogReader1 reader2 = new LogReader1(readerGroup,sharedQ,"Reader2");
        LogReader1 reader3 = new LogReader1(readerGroup,sharedQ,"Reader3");
        writer1.start();
        writer2.start();
        reader1.start();
        reader2.start();
        reader3.start();
        //sharedQ.peek()
    }
}
