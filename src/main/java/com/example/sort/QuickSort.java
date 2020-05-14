package com.example.sort;

import static java.lang.Math.random;

public class QuickSort {

    public static Integer[] populate(int size){
        Integer []arr = new Integer[size];
        for(int i=0;i<size;i++){
            arr[i] = (int)(random()*100);
        }
        return arr;
    }

    public static int partition(Integer[] arr,int lb,int ub){
        int pivot_elem = arr[(lb+ub)/2];
        while(lb<ub){
            while(arr[lb]< pivot_elem){
                lb++;
            }
            while(arr[ub]>pivot_elem){
                ub--;
            }
            if(lb<ub){
                swap(arr,lb,ub);
                lb++;
                ub--;
            }
        }
        return lb;
    }

    public static void swap(Integer[] arr,int i,int j){
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(Integer arr[],int lb,int ub){
        int loc = partition(arr,lb,ub);
        if(lb<loc-1) {
            quickSort(arr, lb, loc - 1);
        }
        if(loc < ub){
            quickSort(arr,loc,ub);
        }
    }
    public static void main(String []args){
        Integer[] arr = populate(15);
        quickSort(arr,0,14);
    }


}
