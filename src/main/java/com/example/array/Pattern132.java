package com.example.array;

import java.util.TreeSet;

public class Pattern132 {

    public boolean find132pattern(int[] input) {
        int[] minArr = input.clone();
        for (int i = 1; i < minArr.length; i++) {
            minArr[i] = Math.min(minArr[i-1], minArr[i]);
        }

        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = input.length - 1; i > 0; i--) {
            int num = input[i];
            if (tree.lower(num) != null) {
                int right = tree.lower(num);
                int left = minArr[i-1];
                if (left < right) {
                    return true;
                }
            }
            tree.add(num);
        }
        return false;
    }
}
