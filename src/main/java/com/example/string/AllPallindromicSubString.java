package com.example.string;

import java.util.ArrayList;
import java.util.List;

public class AllPallindromicSubString {

    public List<String> getAllPallidromicSubString(String src){
        List<String> result = new ArrayList<>();

        return result;
    }

    public int countAllPallidromicSubstring(String input){
        if(input.isEmpty()) {
            return 0;
        }
        int n = input.length();
        int longestSoFar = 0, startIndex = 0, endIndex = 0;
        boolean[][] palindrom = new boolean[n][n];
        int count = 0;

        for(int j = 0; j < n; j++) {
            palindrom[j][j] = true;
            for(int i = 0; i < j; i++) {
                if(input.charAt(i) == input.charAt(j) && (j-i <= 2 || palindrom[i+1][j-1])) {
                    count++;
                    palindrom[i][j] = true;
                    if(j-i+1 > longestSoFar) {
                        longestSoFar = j-i+1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        return count+ input.length();
    }
}
