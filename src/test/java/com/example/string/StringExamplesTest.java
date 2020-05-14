package com.example.string;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StringExamplesTest {

    private StringExamples stringExamples = new StringExamples();

    @Test
    public void testCheckUniquenessOfString(){
        String s1 = "abcdefghi";
        boolean result = stringExamples.checkUniquenessOfString(s1);
        Assert.assertEquals("Should return True",result,true);

        String s2 = "abcdabcd";
        result = stringExamples.checkUniquenessOfString(s2);
        Assert.assertEquals("Should return False",result,false);
    }

    @Test
    void checkUniquenessOfString() {
    }

    @Test
    void reverseString() {

        String s = "narayan";
        String t = stringExamples.reverseString(s);
        String e = "nayaran";
        Assert.assertEquals(e,t);
    }

    @Test
    void testUrlIfy(){
        String s = "Mr John Mathews    ";
        String actual = stringExamples.urlIfy(s);
        String expected = "Mr%20John%20Mathews%20";
        Assert.assertEquals(expected,actual);
    }

    @Test
    void checkAnagramsTest() {
        String text = "forxxorfxdofr";
        String word = "for";
        int expected = 3;
        int actual = stringExamples.checkAnagrams(text,word);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void permutationOfStringTest(){
        String text = "aabc";
        List<String> result = new ArrayList<>();
        stringExamples.permutationOfString(text,"",result);
        int expectedSize = 12;
        Assert.assertEquals(expectedSize,result.size());
    }
}
