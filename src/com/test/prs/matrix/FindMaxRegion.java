package com.test.prs.matrix;

import java.util.Scanner;

public class FindMaxRegion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(findMaxRegion(grid));
    }
    public static int findMaxRegion(int[][] grid){
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
               max =  Math.max(max,countRegion(grid,i,j));
            }
        }
        return max;
    }

    private static int countRegion(int[][] grid, int r, int c) {
        int n = grid.length;
        int m = grid[0].length;
        if(r<0 || c<0 || r>=n || c>= m || grid[r][c]==0)
            return 0;
        int count = grid[r][c]--;// mark it as visited after considering the value
        count += countRegion(grid,r-1,c-1) + countRegion(grid,r-1,c) + countRegion(grid,r-1,c+1)
                + countRegion(grid,r,c+1) + countRegion(grid,r+1,c+1) +  countRegion(grid,r+1,c)
                + countRegion(grid,r+1,c-1) + countRegion(grid,r,c-1);

        return count;
    }
}
