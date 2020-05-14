package com.example.thread.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerSolution {
    public static void main(String[] args) {
        BlockingQueue<Integer> sharedQ = new LinkedBlockingQueue<Integer>();
        Producer producer = new Producer(sharedQ,"Producer");
        Consumer consumer = new Consumer(sharedQ,"Consumer");
        producer.start();
        consumer.start();
    }


}
