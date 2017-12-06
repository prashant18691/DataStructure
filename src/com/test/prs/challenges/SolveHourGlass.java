package com.test.prs.challenges;

import java.util.Scanner;

public class SolveHourGlass {

    static int N=6;

    static int max = Integer.MIN_VALUE;

    static int solve(int[][] arr){
        int i=0;int j=0;
        for(int x=i;x<3*i+3;x++){


            if(i+3<6)
                i+=3;
        }
        return max;
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
        solve(arr);
        //  System.out.println(Arrays.deepToString(arr));
    }
}
