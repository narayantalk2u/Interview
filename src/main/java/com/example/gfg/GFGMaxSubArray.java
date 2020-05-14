package com.example.gfg;


import java.util.*;
import java.lang.*;
import java.io.*;

class GFGMaxSubArray {
    private static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

    public static Integer[] findMaxSubArray(Integer []arr){
        int sum = arr[arr.length-1];
        Integer[] result = new Integer[]{0,0};
        if(sum < 0){
            return result;
        }

        int curSum = arr[0];
        int i=0,j=0;
        for(j=1;j<=arr.length-1;j++){
            while(curSum > sum && i<j-1){
                curSum-=arr[i];
                i++;
            }
            if(curSum == sum){
                //System.out.println("The index range is:(" + i + ", "+ (j-1) +")");
                result[0] = i+1;
                result[1] = j;
                return result;
            }
            if(j<arr.length-1){
                curSum+=arr[j];
            }
        }
        return result;
    }
    public static void manipulate(List<Integer[]> list,int n){
        List<Integer[]> listOResult = new ArrayList<>();
        for(int i=0;i<n;i++){
            //Integer[]input = list.get(i);
            Integer []result = findMaxSubArray(list.get(i));
            listOResult.add(result);
        }
        StringBuffer sb = new StringBuffer();
        for(Integer[] arr : listOResult) {
            for (int i=0;i<arr.length;i++)
            {
                if(arr[i] == 0){
                    sb.append("-1");
                    break;
                }
                sb.append(arr[i] + " ");
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }



    public static List<Integer[]> getListOfArray(int n){
        List<Integer[]> listOfArray = new ArrayList<>();
        for(int i=0;i<n;i++){
            try {
                Integer[] sizeAndSumArray = new Integer[2];
                StringTokenizer tk1 = new StringTokenizer(br.readLine());
                int j=0;
                while(j<2){
                    sizeAndSumArray[j++] = Integer.parseInt(tk1.nextToken());;
                }
                int size = sizeAndSumArray[0];
                Integer[] arr = new Integer[size+1];
                StringTokenizer tk2 = new StringTokenizer(br.readLine());
                j=0;
                while(j<size){
                    arr[j++] = Integer.parseInt(tk2.nextToken());;
                }
                arr[j] = sizeAndSumArray[1];
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