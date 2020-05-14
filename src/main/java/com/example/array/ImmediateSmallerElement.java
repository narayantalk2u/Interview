package com.example.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ImmediateSmallerElement {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void manipulate(List<Integer[]> list, int n){
        List<Integer[]> listOResult = new ArrayList<>();
        for(int i=0;i<n;i++){
            Integer []result = new Integer[list.get(i).length];
            int j = 0;
            for(;j<list.get(i).length-1;j++){
                if(list.get(i)[j] > list.get(i)[j+1]){
                    result[j] = list.get(i)[j+1];
                }else{
                    result[j] = -1;
                }
            }
            result[j] = -1;
            listOResult.add(result);
        }
        StringBuffer sb = new StringBuffer();
        for(Integer[] arr : listOResult) {
            for (int i=0;i<arr.length;i++)
                sb.append(arr[i] + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static List<Integer[]> getListOfArray(int n){
        List<Integer[]> listOfArray = new ArrayList<>();
        for(int i=0;i<n;i++){
            try {
                int size = Integer.parseInt(br.readLine());
                Integer[] arr = new Integer[size];
                StringTokenizer tk = new StringTokenizer(br.readLine());
                int j=0;
                while(j<size){
                    arr[j++] = Integer.parseInt(tk.nextToken());;
                }
                listOfArray.add(arr);
            }catch(IOException ie){
            }
        }
        return listOfArray;
    }

    public static void main (String[] args) {
        int n = 0;
        try {
            n = Integer.parseInt(br.readLine());
        } catch (IOException e) {
        }
        manipulate(getListOfArray(n),n);
    }
}
