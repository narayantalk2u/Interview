package com.example.java8.overloading;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaribleNoOfArgumentTest {

    @Test
    void average() {
        VaribleNoOfArgument testObj = new VaribleNoOfArgument();
        int actual1 = testObj.average(10,20,30);
        Assert.assertEquals(60,actual1);

        int actual2 = testObj.average(10,20,30,40);
        Assert.assertEquals(100,actual2);

        int actual3 = testObj.average();
        Assert.assertEquals(0,actual3);

    }
}