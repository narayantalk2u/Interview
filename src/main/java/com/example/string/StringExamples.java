package com.example.string;


import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * In this file we are solving below problems of string.
 * Q-1) Implement an algorithm to determine if a string has all unique characters, What if you cannot use extra datastructures.
 * Q-2) Given two strings, write a method to decide if one is a permutation of the other.
 *  Q-3) Reverse a String using recurssion
 *  Q-4) Reverse a linkedlist
 *  Q-5) Find depth of a tree
 *  Q-6) Urlify: Write a method to replace all space of a string to %20
 */
public class StringExamples {

    /**
     * Implement q-1
     */
    public boolean checkUniquenessOfString(String s){
        int []countChar = new int[256];
        for(int i=0;i<s.length();i++){
            int ascii = (int)s.charAt(i);
            if(countChar[ascii]!= 0){
                return false;
            }
            countChar[ascii]++;
        }
        return true;
    }

    /**
     * Implemnet of Q-2
     */
    public boolean checkTwoStringsArePermutation(String src,String target){
        int []checkArray = new int[256];
        if(StringUtils.isEmpty(src) || StringUtils.isEmpty(target)){
            throw new IllegalArgumentException("Src String must be provided");
        }
        if(src.length() != target.length()){
            return false;
        }
        for(int i=0;i<src.length();i++){
            checkArray[src.charAt(i)]+=1;
            checkArray[target.charAt(i)]-=1;
        }
        for(int elem:checkArray){
            if(elem!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * Reverse a string using recurssion.
     */
    public String reverseString(String s){
        if(s.isEmpty()){
            return s;
        }
        return reverseString(s.substring(1))+s.charAt(0);
    }

    /**
     * Urlify:
     */
    public String urlIfy(String s){
        char []urlify = new char[1024];
        if(StringUtils.isEmpty(s)){
            return "";
        }
        int j =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != ' '){
                urlify[j] = s.charAt(i);
                j++;
            }
            else{
                while(i<s.length() && s.charAt(i)==' ') i++;
                urlify[j++] = '%';
                urlify[j++] = '2';
                urlify[j++] = '0';
                i--;
            }
        }
        return new String(urlify,0,j);
    }
    /**
     * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards. A permutation
     * is a rea rrangement of letters. The palindrome does not need to be limited to just dictionary words.
     * EXAMPLE
     * Input: Tact Coa
     * Output: True (permutations: "taco cat". "atco cta". etc.)
     * Hints: #106, #121, #134, #136
     */

    /**
     * One Away: There are three types of edits that can be performed on strings: insert a character,
     * remove a character, or replace a character. Given two strings, write a function to check if they are
     * one edit (or zero edits) away.
     * EXAMPLE
     * pale, pIe -> true
     * pales. pale -> true
     * pale. bale -> true
     * pale. bake -> false
     * Hints: #23, #97, #130
     */

    /**
     * String Compression: Implement a method to perform basic string compression using the counts
     * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
     * "compressed" string would not become smaller than the original string, your method should return
     * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
     * Hints: #92, # 11 0
     */

    /**
     * Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
     * bytes, write a method to rotate the image by 90 degrees. (an you do this in place?
     * Hints: #51, #100
     */

    /**
     * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
     * column are set to O.
     * Hints: # 17, #74, #102
     */

    /**
     * String Rotation: Assume you have a method isSubst ring which checks if one word is a substring
     * of another. Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one
     * call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
     * Hints: #34, #88, #104
     */

    /**
     * Count no of anagrams
     */
    public int checkAnagrams(String text,String word){
        int textLength = text.length();
        int wordLength = word.length();
        int count = 0;
        int arr[] = new int[256];
        for(int i=0;i<wordLength;i++){
            arr[word.charAt(i)]++;
            arr[text.charAt(i)]--;
        }
        if(checkArray(arr)){
            count++;
        }

        for(int i=wordLength;i<textLength;i++){
            arr[text.charAt(i)]--;
            arr[text.charAt(i-wordLength)]++;
            if(checkArray(arr)){
                count++;
            }
        }
        return count;
    }

    public boolean checkArray(int []arr){
        for(int elm:arr){
            if(elm != 0){
                return false;
            }
        }
        return true;
    }

    public void permutationOfString(String str, String ans, List<String> ansString){
        if(str.length() == 0){
            System.out.println(ans+" ");
            ansString.add(ans);
            return ;
        }
        boolean checkAlpha[] = new boolean[26];

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            String ros = str.substring(0,i) + str.substring(i+1);

            if(checkAlpha[ch-'a'] == false){
                permutationOfString(ros,ans+ch,ansString);
            }
            checkAlpha[ch-'a'] = true;
        }
    }

    public void permutationOfString(String str,String ans){
        if(str.length() == 0){
            System.out.println(ans+" ");
            return;
        }
        boolean checkAlpha[] = new boolean[26];

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            String ros = str.substring(0,i) + str.substring(i+1);

            if(checkAlpha[ch-'a'] == false){
                permutationOfString(ros,ans+ch);
            }
            checkAlpha[ch-'a'] = true;
        }
    }


}
