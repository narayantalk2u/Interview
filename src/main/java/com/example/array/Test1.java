package com.example.array;

import java.util.Scanner;

class  Test implements Runnable{
    int x,y;


    @Override
    public void run() {
        for (int i=0;i<1000;i++)
            synchronized (this){
            x= 12;
            y=12;
            }
        System.out.println(""+x+","+y);
    }
}

public class Test1 {

    public static void main(String[] args) {
        /*String csv = "sue,5";
        Scanner in = new Scanner(csv);
        in.useDelimiter(",");
        int j = in.nextInt();
        System.out.println(j);*/
        Test run = new Test();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t1.start();
        t2.start();
    }
}
