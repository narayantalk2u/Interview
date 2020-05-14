package com.example.array;

import java.util.Arrays;
import java.util.Scanner;
public class TripletFind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements in array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int res = countTriplets(arr,n);
        System.out.println(res);
    }
    public static int countTriplets(int []arr, int n) {
        int count = 0;
        for (int i = 0; i < n -2; i++){
            if (arr[i] +arr[i + 1] == arr[i + 2]) {
                count = count + 1 ;
            }
        }
        if (count > 0)
            return count;
        else
            return -1;
    }
}
