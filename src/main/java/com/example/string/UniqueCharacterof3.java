package com.example.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * a string contains oly 3 characters in a string -'a','b','c' . if in another or same string,
 * 2 different chars occur together they are replaced with the third char. operation is repeated till no
 * reduction is possible. the string must be evaluated from left to right always.
 * input - abbc
 * output- 1
 */
public class UniqueCharacterof3 {

    public static void main(String[] args) {

        String s = "abbc";
        //String s = "aaac";
        //String s = "aaaa";
        Set<Character> uniqueChars = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            uniqueChars.add(s.charAt(i));
        }
        //If ask only for a,b and c
       /* Set<Character> uniqueChars1 = new HashSet<Character>();
        uniqueChars1.addAll(Arrays.asList(new Character[] {'a', 'b','c'}));*/
        Stack<Character> stack = new Stack<Character>();
        int i = 1;
        Character newChar = s.charAt(0);
        while (i < s.length()) {
            if (stack.isEmpty() || stack.peek().equals(newChar)) {
                stack.push(newChar);
                newChar = s.charAt(i++);
            } else {
                Character top = stack.pop();
                for (Character unChar : uniqueChars) {
                    if (!unChar.equals(top) && !unChar.equals(newChar)) {
                        newChar = unChar;
                        break;
                    }
                }
            }
        }
        boolean change = true;
        while (change) {
            if (stack.isEmpty() || stack.peek().equals(newChar)) {
                stack.push(newChar);
                change = false;
            } else {
                Character top = stack.pop();
                for (Character unChar : uniqueChars) {
                    if (!unChar.equals(top) && !unChar.equals(newChar)) {
                        newChar = unChar;
                        break;
                    }
                }
            }
        }
        System.out.println(stack.size() + " - " + stack);
    }
}
