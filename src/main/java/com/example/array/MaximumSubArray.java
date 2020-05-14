package com.example.array;

public class MaximumSubArray {

    public boolean findMaxSubArray(int []arr,int sum){
        if(sum < 0){
            return false;
        }
        int curSum = arr[0];
        int i=0,j=0;
        for(j=1;j<=arr.length;j++){
            while(curSum > sum && i<j-1){
                curSum-=arr[i];
                i++;
            }
            if(curSum == sum){
                System.out.println("The index range is:(" + i + ", "+ (j-1) +")");
                return true;
            }
            if(j<arr.length){
                curSum+=arr[j];
            }
        }
        return false;
    }
}
