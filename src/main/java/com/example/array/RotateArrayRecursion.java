package com.example.array;

import java.util.Arrays;
import java.util.List;

public class RotateArrayRecursion {
    /**
     * Description #
     *
     * Given an array of integers, rotate the array by NNN elements where NNN is an integer:
     *
     *     For positive values of NNN, perform a right rotation.
     *     For negative values of NNN, perform a left rotation.
     *
     * Make sure you make changes to the original array.
     *
     * Solution 1 #
     * Runtime complexity #
     *
     * The runtime complexity of the code is linear, O(n)O(n)O(n).
     * Memory complexity #
     *
     * The memory complexity of the code is constant, O(1)O(1)O(1).
     *
     * Here is how the solution works:
     *
     *     Normalize the rotations so they do not exceed the length of the array.
     *     Convert negative rotations to positive rotations.
     *     Reverse the elements of the original array.
     *     Reverse the elements from 0−>N−10 -> N-10−>N−1.
     *     Reverse the elements from N−>N ->N−> length−1length-1length−1.
     */

    static void rotateArray1(List<Integer> arr, int n) {
        int len = arr.size();
        // Let's normalize rotations
        // if n > array size or n is negative.
        n = n % len;
        if (n < 0) {
            // calculate the positive rotations needed.
            n = n + len;
        }

        List<Integer> temp = Arrays.asList(new Integer[n]);

        // copy last N elements of array into temp
        for (int i = 0; i < n; i++) {
            temp.set(i, arr.get(len - n + i));
        }

        // shift original array
        for (int i = len - 1; i >= n; i--) {
            arr.set(i, arr.get(i - n));
        }

        // copy temp into original array
        for (int i = 0; i < n; i++) {
            arr.set(i, temp.get(i));
        }
    }
       /* public static void main(String []args){
            List<Integer> arr = Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40);
            System.out.println("Array Before Rotation\n" + arr);
            rotateArray(arr, -3);
            System.out.println("Array After Rotation\n" + arr);
        }*/
    /**
     *
     *  Solution 2 #
     * Runtime complexity #
     *
     * The runtime complexity of this code is linear, O(n)O(n)O(n).
     * Memory complexity #
     *
     * The memory complexity of this code is linear, O(n)O(n)O(n).
     *
     * Here is how the solution works:
     *
     *     Store the last NNN elements into a temporary array.
     *     Shift the original array towards the right by L−NL-NL−N places. Here, LLL is the length of the ​array.
     *     Copy the temporary array at the beginning of the original array.
     */
     static void rotateArray2(List<Integer> arr, int n) {
         int len = arr.size();
         // Let's normalize rotations
         // if n > array size or n is negative.
         n = n % len;
         if (n < 0) {
             // calculate the positive rotations needed.
             n = n + len;
         }

         List<Integer> temp = Arrays.asList(new Integer[n]);

         // copy last N elements of array into temp
         for (int i = 0; i < n; i++) {
             temp.set(i, arr.get(len - n + i));
         }

         // shift original array
         for (int i = len - 1; i >= n; i--) {
             arr.set(i, arr.get(i - n));
         }

         // copy temp into original array
         for (int i = 0; i < n; i++) {
             arr.set(i, temp.get(i));
         }
     }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 10, 20, 0, 59, 86, 32, 11, 9, 40);
        System.out.println("Array Before Rotation\n" + arr);
        rotateArray2(arr, -3);
        System.out.println("Array After Rotation\n" + arr);
    }
}
