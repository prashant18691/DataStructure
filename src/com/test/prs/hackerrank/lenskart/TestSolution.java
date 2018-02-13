package com.test.prs.hackerrank.lenskart;/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestSolution {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        // Writing output to STDOUT
        int t = s.nextInt();
        while(t>0){
            int n = s.nextInt();
            int[] ip = new int[n];
            for(int i =0;i<n;i++)
                ip[i] = s.nextInt();
            System.out.println(solve(ip));
            t--;
        }

    }

    private static int solve(int[] arr){

        if(arr.length==2){
            return Math.abs(arr[1]-arr[0]);
        }
        int maxDiff = -1;
        int n = arr.length;
        int maxRight = arr[n-1];
        int min = arr[n-1];

        for (int i = n-2; i >= 0; i--)
        {
            if(arr[i]<min)
                min=arr[i];
            if (arr[i] > maxRight){
                maxRight = arr[i];
            }
           int diff = maxRight - min;
            if(diff>maxDiff)
                maxDiff =diff;
        }
        return maxDiff;
    }

}
