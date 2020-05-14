package com.example.search;

public class BinarySearch {
    /**
     * Given a sorted array of integers, return the index of the given key. Return -1 if the key is not found.
     */
    public int binarySearchRecursive(int []arr,int key, int lowIdx, int highIdx){
        if(lowIdx > highIdx){
            return -1;
        }
        int mid = (lowIdx +highIdx)/2;

        if(key == arr[mid]){
            return mid;
        }else if(key > arr[mid]){
            return binarySearchRecursive(arr,key,mid+1,highIdx);
        }else{
            return binarySearchRecursive(arr,key,lowIdx,mid-1);
        }
    }

    public int binarySearchIterative(int []arr,int key){
        int lowidx = 0;
        int highIdx = arr.length-1;

        while(lowidx <= highIdx){
            int mid = (lowidx + highIdx)/2;
            if(key == arr[mid]){
                return mid;
            }else if(key > arr[mid]){
                lowidx = mid+1;
            }else{
                highIdx = mid-1;
            }
        }
        return -1;
    }
}
