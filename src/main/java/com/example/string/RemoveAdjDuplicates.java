package com.example.string;

public class RemoveAdjDuplicates {

   /* public String removeAdjDuplicates(String src){
        StringBuilder sb = new StringBuilder(src.charAt(0));
        for (int i=0;i<src.length();){
            int j = i+1;
            while(j < src.length() && src.charAt(i) == src.charAt(j)){
                j++;
            }
            i = j;
            if(src.charAt(i) != src.charAt(j)){
                sb.append(src.charAt(i));
            }

        }
        return sb.toString();
    }*/

   public String removeDuplicateAdj(String src){
       char []chars = src.toCharArray();
       char prev = '\0';
       int k = 0;
       for(int i=0;i<src.length();i++){
           if(prev != chars[i]){
               chars[k++] = chars[i];
               prev = chars[i];
           }
       }
       return new String(chars).substring(0,k);
   }
}
