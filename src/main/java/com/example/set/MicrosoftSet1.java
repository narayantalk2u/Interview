package com.example.set;

/**
 * 1. Smallest non negative number in a array
 * 2. Given a grid with costs in each cell.You can enter through any item in Row 0 and exit through any row n-1. Find the minimum cost path
 *
 * 1. Connect all nodes at same level in a Binary Tree
 * 2. Median in a running stream of numbers
 *
 * 1. Design a group chat both front end and back end.
 */
public class MicrosoftSet1 {

    public int smallestNonNegative(int []arr){
        int smallest = Integer.MAX_VALUE;
        for(int elem: arr){
            if(elem >= 0 && elem < smallest){
                smallest = elem;
            }
        }
        return smallest;
    }

    /**
     * Q-2 : Analysis
     * The path to reach (m, n) must be through one of the 3 cells: (m-1, n-1) or (m-1, n) or (m, n-1).
     * So minimum cost to reach (m, n) can be written as “minimum of the 3 cells plus cost[m][n]”.
     * minCost(m, n) = min (minCost(m-1, n-1), minCost(m-1, n), minCost(m, n-1)) + cost[m][n]
     */
    public int minCostPathProblem(int [][]matrix,int m,int n){
        int cost = 0;
        if(m < 0 || n< 0){
            return Integer.MAX_VALUE;
        }else if(m == 0 && n == 0){
            return matrix[m][n];
        }else{
            return min(minCostPathProblem(matrix,m-1, n-1),
                    minCostPathProblem(matrix,m-1, n),
                    minCostPathProblem(matrix,m, n-1)) + matrix[m][n];
        }
    }

    public int min(int a,int b,int c){
        if(a < b){
            if(a < c){
                return a;
            }else{
                return c;
            }
        }else{
            if(b<c){
                return b;
            }else{
                return c;
            }
        }
    }

    /**
     * mincost in iterative ways
     */


}
