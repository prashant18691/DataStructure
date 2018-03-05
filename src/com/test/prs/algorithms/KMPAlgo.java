package com.test.prs.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class KMPAlgo {
    public void findPattern(String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        int[] lps = new int[m];
        computeLPS(pattern,m,lps);
        int i=0,j=0;
        while(i<n){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;j++;
            }
            if(j==m){
                System.out.println("Pattern found at "+(i-j));
                j = lps[j-1];
            }
            else if(i<n && text.charAt(i)!=pattern.charAt(j)){
                if(j!=0)
                    j = lps[j-1];
                else
                    i++;
            }
        }
    }

    private void computeLPS(String pattern, int m, int[] lps) {// AAACAAAA    i>j
        lps[0] = 0;                                            // 01201233
        int i = 1,j = 0;
        while(i<m){
            if(pattern.charAt(i)==pattern.charAt(j)){
                j++;
                lps[i]=j;
                i++;
            }
            else{
                if(j!=0)
                    j = lps[j-1];
                else
                {
                    lps[i] = j;
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(lps));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        KMPAlgo kmp = new KMPAlgo();
        kmp.findPattern(s.next(), s.next());
    }
}
