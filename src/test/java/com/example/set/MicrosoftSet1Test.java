package com.example.set;

import com.example.set.MicrosoftSet1;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

class MicrosoftSet1Test {

    @Test
    void smallestNonNegative() {
        int[] array = { 2, -1, 4, 6, 3, 5 };
        MicrosoftSet1 set1 = new MicrosoftSet1();
        int actual = set1.smallestNonNegative(array);
        assertEquals(2,actual);
    }

    @Test
    void minCostPathProblem() {
        int cost[][] = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        MicrosoftSet1 set1 = new MicrosoftSet1();
        int actual = set1.minCostPathProblem(cost,2,2);
        assertEquals(8,actual);
    }
}