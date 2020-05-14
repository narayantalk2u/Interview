package com.example.sort;

public class InsertionSort {

    public static Integer[] insertionSort(Integer []input){
        for(int i = 1;i<input.length;i++){
            int key = input[i];
            int j = i-1;
            while(j>=0 && input[j] > key){
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = key;
        }
        return input;
    }

    private static void insertionSortRecursive(int[] input, int i) {
        if (i <= 1) {
            return;
        }
        insertionSortRecursive(input, i - 1);
        int key = input[i - 1];
        int j = i - 2;
        while (j >= 0 && input[j] > key) {
            input[j + 1] = input[j];
            j = j - 1;
        }
        input[j + 1] = key;
    }
}
