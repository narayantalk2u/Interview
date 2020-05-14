package com.example.string;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveAdjDuplicatesTest {

    @Test
    void removeAdjDuplicates() {
        String test = "aadbccaeff";
        RemoveAdjDuplicates testObj = new RemoveAdjDuplicates();
        String actual = testObj.removeDuplicateAdj(test);
        String expected = "adbcaef";
        Assert.assertEquals(expected,actual);
    }
}