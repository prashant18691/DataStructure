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

class FindMaxPower {
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

    private static int solve(int[] elements){

        int max = elements[1];
        int min = elements[0];
        int max_diff = Math.abs(max-min);
        for(int i =0;i<elements.length;i++){
            if(elements[i]<min)
                min = elements[i];
            if(elements[i]>max)
                max = elements[i];
            int diff = Math.abs(max-min);
            if(diff>max_diff)
                max_diff = diff;
        }
        return max_diff;
    }

}
