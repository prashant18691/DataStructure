package com.test.prs.challenges.hackerearth;

import java.util.Scanner;

public class TestSubsequence {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        long[] in = new long[n];
        for (int i = 0; i < n; i++) {
            in[i] = s.nextLong();
        }
        solve(in,n,k);
        System.out.println(max==null?-1:max);
    }

    private static void solve(long[] in,int n,int k) {
        getCombination(in,n,k);
    }

    static void getCombination(long arr[], int n, int r)
    {
        long data[]=new long[r];
        combinationUtil(arr, n, r, 0, data, 0);
    }

    static Integer  max = Integer.MIN_VALUE;
    static void combinationUtil(long arr[], int n, int r, int index,
                                long data[], int i){
        if (index == r)
        {
            int sum = 0;
            for (int j = 0; j < r-1 ; j++) {
                if(data[j+1]>data[j])
                    sum+=data[j+1]-data[j];
                else
                    break;
            }
            if (sum>max)
                max = sum;
            return;
        }

        if (i >= n)
            return;

        data[index] = arr[i];
        combinationUtil(arr, n, r, index+1, data, i+1);
        combinationUtil(arr, n, r, index, data, i+1);
    }
}
