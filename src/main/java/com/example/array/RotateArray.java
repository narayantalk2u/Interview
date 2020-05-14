package com.example.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 Given an array of N size. The task is to rotate array by d elements where d is less than or equal to N.

 Input:
 The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow.
 Each test case consist of three lines. The first line of each test case consists of an integer N, where N is the
 size of array. The second line of each test case contains N space separated integers denoting array elements.
 The third line of each test case contains "d" .

 Output:
 Corresponding to each test case, in a new line, print the modified array.

 Constraints:
 1 ≤ T ≤ 200
 1 ≤ N ≤ 200
 1 ≤ A[i] ≤ 1000

 Example:
 Input
 1
 5
 1 2 3 4 5
 2

 Output
 3 4 5 1 2
 ** For More Input/Output Examples Use 'Expected Output' option **
 */

public class RotateArray {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Integer[] getArrayList(int n){
        Integer[] arr = null;
        try {
            int size = Integer.parseInt(br.readLine());
            arr = new Integer[size];
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int j=0;
            while(j<size){
                arr[j++] = Integer.parseInt(tk.nextToken());;
            }
        }catch(IOException ie){
        }
        return arr;
    }

    public static void rotateArray(Integer[] arr,int m){
        Integer[] temp = new Integer[Math.abs(m)];
        if(m>=0){
            for(int i=0;i<m;i++)
                temp[i] = arr[i];
            for(int i=m;i<arr.length;i++)
                arr[i-m] = arr[i];
            for(int i=arr.length-m,j=0;i<arr.length;i++,j++)
                arr[i] = temp[j];
        }else{
            for(int i=arr.length+m,j=0;i<arr.length;i++,j++)
                temp[j] = arr[i];
            for(int i=arr.length+m-1,j=arr.length-1;i>=0;i--,j--)
                arr[j] = arr[i];
            for(int i=Math.abs(m)-1,j=0;i>=0;i--,j++)
                arr[j] = temp[i];
        }
    }

    public static void printArrayList(Integer[] arr){
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<arr.length;i++)
            sb.append(arr[i] + " ");
        sb.append("\n");
        System.out.println(sb);
    }
    public static void main(String []args){
        Integer[] listArray;
        int n=0;
        try{
            n = Integer.parseInt(br.readLine());
        }catch (IOException ie){
        }
        listArray = getArrayList(n);
        int m = 0;
        try{
            m = Integer.parseInt(br.readLine());
        }catch (IOException ie){
        }
        rotateArray(listArray,m);
        printArrayList(listArray);
    }

}
