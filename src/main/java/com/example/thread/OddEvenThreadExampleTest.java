package com.example.thread;

public class OddEvenThreadExampleTest {

    public static void main(String[] args) {

        OddEvenThreadExample oddRunnable=new OddEvenThreadExample(1);
        OddEvenThreadExample evenRunnable=new OddEvenThreadExample(0);

        Thread t1=new Thread(oddRunnable,"Odd");
        Thread t2=new Thread(evenRunnable,"Even");

        t1.start();
        t2.start();

    }
}
