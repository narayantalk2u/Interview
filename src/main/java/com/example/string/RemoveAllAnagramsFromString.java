package com.example.string;

import java.util.ArrayList;
import java.util.List;

public class RemoveAllAnagramsFromString {
    public static boolean checkArray(int []arr){
        for(int a: arr){
            if(a!=0){
                return false;
            }
        }
        return true;
    }

    public static  boolean checkAnagram(String src, String dest){
        int []countChar = new int[256];
        if(src.length()!=dest.length()){
            return false;
        }
        for(int i=0;i<src.length();i++){
            int asciiSrc = (int)src.charAt(i);
            int asciiDest = (int)dest.charAt(i);
            countChar[asciiSrc]++;
            countChar[asciiSrc]--;
        }
        if(checkArray(countChar)) {
            return true;
        }else{
            return false;
        }
    }

    public static void driveCode(){
        String src = "code";
        String dest = "edoc";
        List<String> list = new ArrayList<>();
        list.add("code");
        list.add("ecod");
        list.add("doce");
        list.add("farmer");
        list.add("farmre");
        list.add("framer");
        list.add("frame");
        list.add("XYZ");

        //ListIterator<String> li = list.listIterator();
        for(int i=0;i<list.size();i++){
            String checkStr = list.get(i);
            for(int j=i+1;j<list.size();){
                if(checkAnagram(checkStr,list.get(j))){
                    list.remove(j);
                }else{
                    j++;
                }
            }
        }
        System.out.println(list);
    }

    public static void main(String args[]){
        driveCode();
    }
}
