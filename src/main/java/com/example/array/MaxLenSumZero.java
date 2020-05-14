package com.example.array;

import java.util.HashMap;
import java.util.Map;

public class MaxLenSumZero {

    public int getMaxLen(Integer []arr){
        int sum_0 = 0;
        int cur_sum = 0;
        int max_len = 0;
        Map<Integer,Integer> sumHashMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            cur_sum+=arr[i];
            if (arr[i] == 0 && max_len == 0)
                max_len = 1;

            if (cur_sum == 0)
                max_len = i + 1;

            // Look this sum in hash table
            Integer prev_i = sumHashMap.get(cur_sum);

            // If this sum is seen before, then update max_len
            // if required
            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else // Else put this sum in hash table
                sumHashMap.put(cur_sum, i);
        }
        return max_len;
    }
}
