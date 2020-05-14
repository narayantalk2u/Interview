package com.example.array.findsum;

/**
 * Solution 2 #
 *
 *     Note: This solution works only for sorted data.
 *
 * Runtime complexity #
 *
 * The runtime complexity of this solution is linear, O(n)O(n)O(n).
 * Memory complexity #
 *
 * The memory complexity of this solution is constant, O(1)O(1)O(1).
 *
 * To understand the algorithm for this solution, let’s look at the pseudo-code below:
 *
 * // assume 0 is the first index in array
 * // and n is the total number of elements in array
 * left = 0
 * right = n - 1
 * while left is less than right
 *     sum = array[left] + array[right]
 *     if sum == val return true
 *     if sum is less than val
 *         // sum is smaller than value
 *         // means pair can only exist to the
 *         // right of left element, so left element
 *         // should be moved one step next
 *         left = left + 1
 *     else
 *         // sum is greater than value
 *         // means pair can only exist to the
 *         // left of right element, so right element
 *         // should be moved one step previous
 *         right = right - 1
 */

public class FindSumSol2 {
    static boolean findSumOfTwo(int[] A, int val) {
        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            int sum = A[i] + A[j];
            if (sum == val) {
                return true;
            }

            if (sum < val) {
                ++i;
            } else {
                --j;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] v = new int[]{1, 3, 4, 5, 7, 14, 15}; //Sorted Array
        int[] test = new int[]{3, 20, 1, 2, 7};
        for (int i = 0; i < test.length; i++){
            boolean output = findSumOfTwo(v, test[i]);
            System.out.println("findSumOfTwo(v, " + test[i] + ") = " + (output ? "true" : "false"));
        }
    }
}
