package com.example.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubArrayTest {

    @Test
    void findMaxSubArray() {
        int arr[] = {1,4,5,8,3,10,11,21,2,5,7};
        int sum = 30;
        MaximumSubArray testObj = new MaximumSubArray();
        boolean expectResult = true;
        boolean actualResult = testObj.findMaxSubArray(arr,sum);
        assertEquals(expectResult,actualResult);

    }
}