package com.test.prs.hackerrank;

import java.util.Scanner;

/**
 * @url https://www.hackerrank.com/challenges/lena-sort/problem
 * @author Prashant Upadhya
 */
public class LenaSort {
    static int[] dp = new int[100001];
    static{
        dp[1] = 0;
        for(int i = 2;i < dp.length;i++){
            dp[i] = i-1 + dp[i/2] + dp[(i-1)/2];
        }
    }

    static void dfs(int low, int high, int l,long c, int[] dp, int[] a)
    {
        if(high-low <= 0)return;
        if(high-low == 1){
            a[l] = low;
            return;
        }
        for(int k = 0;k <= high-low-1;k++){
            if(dp[k] + dp[high-low-1-k] <= c-(high-low-1) &&
                    c-(high-low-1) <= (long)k*(k-1)/2+(long)(high-low-1-k)*(high-low-1-k-1)/2){
                a[l] = k + low;
                long lv = dp[k], rv = c-(high-low-1)-dp[k];
                if(rv > (long)(high-low-1-k)*(high-low-1-k-1)/2){
                    rv = (long)(high-low-1-k)*(high-low-1-k-1)/2;
                    lv = c-(high-low-1)-dp[k];
                }
                dfs(low, k+low, l+1, lv, dp, a);
                dfs(k+low+1, high, l+k+1, rv, dp, a);
                return;
            }
        }
    }

    public static void main1(String[] args) {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        while(q>0){
            long n = s.nextLong();
            long c = s.nextLong();
                long inf = dp[(int)n], sup = n*(n-1)/2;
                if(inf <= c && c <= sup){
                    int[] ret = new int[(int)n];
                    dfs(0, (int)n, 0,  c, dp, ret);
                    for(int i = 0;i < n;i++){
                        System.out.print(ret[i]+1 + " ");
                    }
                    System.out.println();
                }else{
                    System.out.println(-1);
                }
            q--;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        while(q>0){
            long n = s.nextLong();
            long c = s.nextLong();

            q--;
        }
    }


}

//Another solution
/*
    import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    long[] lowerBound, upperBound;

    Solution() {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        lowerBound = new long[100001];
        upperBound = new long[100001];

        for (int i = 0; i < 100001; i++) {
            lowerBound[i] = -1;
            upperBound[i] = -1;
        }
        lowerBound[0] = 0;

        for(int a0 = 0; a0 < q; a0++){
            int len = in.nextInt();
            long c = in.nextLong();
            // your code goes here

            if (c < getLowerBound(len) || c > getUpperBound(len)) {
                System.out.println(-1);
                continue;
            }
            int[] solution = new int[len];
            this.solve(solution, 0, len, 1, c);
            for (int i : solution) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        in.close();
    }

    void solve(int[] solution, int left, int right, int base, Long c) {
    	int len = right - left;
        if (len == 0 && c == 0) {
            return;
        }
        c = c - len + 1;
        for (int i = 0; i < (len + 1) / 2; i++) {
            int i1 = len - i - 1;
            if (getLowerBound(i) + getLowerBound(i1) <= c && getUpperBound(i) + getUpperBound(i1) >= c) {
            	solution[left] = i + base;
            	long c1 = getLowerBound(i);
            	long c2 = c - c1;
            	if (c2 > getUpperBound(i1)) {
            		c2 = getUpperBound(i1);
            		c1 = c - c1;
            	}
            	solve(solution, left + 1, left + i + 1, base, c1);
            	solve(solution, left + i + 1, right, base + i + 1, c2);
            	return;
            }
        }
        return;
    }

    long getUpperBound(int i) {
        if (upperBound[i] == -1) {
            upperBound[i] = (long) i * ((long) i - 1) / 2;
        }
        return upperBound[i];
    }

    long getLowerBound(int i) {
        if (lowerBound[i] == -1) {
            lowerBound[i] = i - 1 + getLowerBound(i / 2) + getLowerBound((i - 1) / 2);
        }
        return lowerBound[i];
    }
}


        */

/*

    import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        long[] mins = new long[100001];
        long[] maxes = new long[100001];
        mins[2] = 1;
        maxes[2] = 1;
        for (int i = 3; i <= 100000; i++) {
            mins[i] = i-1+mins[(i-1)/2]+mins[(i-1)-(i-1)/2];
            maxes[i] = maxes[i-1]+i-1;
        }
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int len = in.nextInt();
            int c = in.nextInt();
            if (maxes[len]<c||mins[len]>c) {
                System.out.println(-1);
                continue;
            }
            System.out.println(portion(len, c, 1, mins, maxes, new StringBuilder()));
        }
    }

    public static StringBuilder portion(int len, long c, int offset, long[] mins, long[] maxes, StringBuilder ans) {
        if (len==0) {
            return ans;
        }
        if (len==1) {
            ans.append(offset+" ");
            return ans;
        }
        int pivot = 0;
        c -= len-1;
        while (mins[pivot]+mins[len-pivot-1]>c||maxes[pivot]+maxes[len-pivot-1]<c)
            pivot++;
        long newc = mins[pivot];
        while (mins[len-pivot-1]>c-newc||maxes[len-pivot-1]<c-newc)
            newc++;
        ans.append((pivot+offset)+" ");
        portion(pivot, newc, offset, mins, maxes, ans);
        portion(len-pivot-1, c-newc, offset+pivot+1, mins, maxes, ans);
        return ans;
    }
}


 */