package com.example.set;

public class MazeSol1 {

    /**
     * Calculate if there is a path exist between two adjacent indexes or not.
     * For up i >=0 and for down i<row
     * For left j>=0 anf for right j<col
     */
    public boolean isThereAPath(int graph[][],int i,int j){
        int row = graph.length;
        int col = graph[0].length;
        if(i>=0 && i<row && j>=0 && j<col && graph[i][j] == 1 ){
            return true;
        }
        return false;
    }

    /**
     * Maze solver Util to create a solution matrix of path
     */
    public void mazeSolverUtil(int graph[][], int i,int j, int sol[][]){

    }

    /**
     * Maze solver in resursive way
     */
    public void mazeSolver(int graph[][],int i,int j,int sol[][]){

    }

}
