package com.test.prs.codeChef.challenge.MayChallenge;

import java.util.Arrays;
import java.util.Scanner;


public class REDONE {
    private static final long MOD =1000000007;
    private static final int N = 1000001;
    static long[] dp = new long[1000001];
    private static final int MAX = Integer.MAX_VALUE;

    static {
        Arrays.fill(dp, MAX);
        dp[1] = 1;
        for (int i = 2; i < N; i++) {
            dp[i] = i+dp[i-1]+i*dp[i-1];
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            System.out.println(dp[n]%MOD);
        }
    }
}
