package com.example.java8.overloading;

public class VaribleNoOfArgument {
    /**
     *
     */
    public int average(int ...vals){
        int sum = 0;
        for(int val:vals){
            sum+=val;
        }
        return sum;
    }

}
