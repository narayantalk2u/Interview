package com.example.sort;

import com.example.sort.BubbleSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {

    @Test
    public void testBubbleSort(){
        Integer[] array = { 2, 1, 4, 6, 3, 5 };
        Integer[] sortedArray = { 1, 2, 3, 4, 5, 6 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);

        assertArrayEquals(array, sortedArray);
    }

    @Test
    public void testOptimizedBubbleSort(){
        Integer[] array = { 2, 1, 4, 6, 3, 5 };
        Integer[] sortedArray = { 1, 2, 3, 4, 5, 6 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.optimizedSort(array);

        assertArrayEquals(array, sortedArray);
    }

}
