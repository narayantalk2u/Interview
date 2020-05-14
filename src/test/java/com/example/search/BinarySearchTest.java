package com.example.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void binarySearchRecursive() {
        BinarySearch bs = new BinarySearch();
        int[] arr = {1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222};
        int[] inputs = {10, 49, 99, 110, 176};
        int[] outputs = {1, -1, 8, -1, 14};

        for (int i = 0; i < inputs.length; i++) {
            //System.out.println("binSearch(arr, " + inputs[i]+ ") = " +  bs.binarySearchRecursive(arr, inputs[i],0,arr.length-1));
            assertEquals(outputs[i],bs.binarySearchRecursive(arr, inputs[i],0,arr.length-1));

        }
    }

    @Test
    void binarySearchIterative() {
        BinarySearch bs = new BinarySearch();
        int[] arr = {1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222};
        int[] inputs = {10, 49, 99, 110, 176};
        int[] outputs = {1, -1, 8, -1, 14};

        for (int i = 0; i < inputs.length; i++) {
            //System.out.println("binSearch(arr, " + inputs[i]+ ") = " +  bs.binarySearchIterative(arr, inputs[i]));
            assertEquals(outputs[i],bs.binarySearchIterative(arr, inputs[i]));
        }
    }
}