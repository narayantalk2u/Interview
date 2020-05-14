package com.example.array;

import static java.lang.Integer.max;

public class KadaneAlgorithmMaxSubArray {
    /**
     * Kadane algoritm to findout max sum of subarray
     * @param a
     * @return
     */
    public static int kadaneAlgorithmMaxSubArray(int a[]) {
        int currMax = a[0];
        int globalMax = a[0];

        int sum = 0;
        int start = 0;
        int end = 0;

        for (int i = 1; i < a.length; ++i) {
            sum = currMax + a[i];
            currMax = max(a[i], sum);
            globalMax = max(globalMax, currMax);

            // updating start index
            if (sum < currMax) {
                start = i;
            }

            // updating end index
            if (globalMax < currMax) {
                end = i;
            }
        }
        System.out.println("Maximum contiguous sum is " + globalMax);
        System.out.println("Starting index " + start + "Ending index " +end);
        return globalMax;
    }

    /*Driver program to test maxSubArraySum*/
    public static void main(String []args)
    {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int max_sum = kadaneAlgorithmMaxSubArray(a);
        System.out.println("Maximum sum: "+max_sum);
    }
}
