package com.test.prs.challenges;

import java.util.Scanner;

public class SolveHourGlass {

    static int N=6;

    static int max = Integer.MIN_VALUE;

    static int solve(int[][] arr){
       int r = 0;int c = 0;
        return findMaxSum(arr, r, c);
    }

    private static int findMaxSum(int[][] arr, int r, int c) {
        int sum = 0;
        for(int i=r;i<r+3;i++){
           for(int j=c;j<c+3;j++)
               sum += arr[i][j];
           if(max<sum)
               max=sum;
       }
        c = checkBoundary(c);
        r = checkBoundary(r);
        if(c<=3)
            findMaxSum(arr, r, c);
        if(r<=3)
            findMaxSum(arr, r, c);
        return max;
    }


    private static int checkBoundary(int k) {
        if(k<3)
            k++;
        else
            k=0;
        return k;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s  = new Scanner(System.in);
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j] = s.nextInt();
            }
        }
        System.out.println(solve(arr));
        //  System.out.println(Arrays.deepToString(arr));
    }
}
