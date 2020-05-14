package com.example.array;

import java.util.HashSet;
import java.util.Set;

public class GetDuplicateIncrementMinSum {

    public static int getSuplicateincrementMinSum(Integer []arr){
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(!set.contains(arr[i])){
                set.add(arr[i]);
            }else{
                while(set.contains(arr[i])){
                    arr[i]+=1;
                }
                set.add(arr[i]);
            }
        }
        for(Integer val:set){
            sum+=val;
        }
/*
        Integer sum1 = set.stream()
                .reduce(0, (a, b) -> a + b);
*/
        Integer sum1 = set.stream().reduce(0,Integer::sum);
        return sum1;
    }

    public static void main(String []args){
        Integer arr[] = new Integer[]{3,2,1,2,7};
        System.out.println(getSuplicateincrementMinSum(arr));
    }
}
