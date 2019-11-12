package com.test.prs.codeChef.challenge.AprilChallenge;

import java.util.Scanner;


public class MaxRem {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = reader.nextInt();
        }
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        int max = findMax(A);
        int diff = max;
        for (int i : A) {
            if (max-i>0)
                diff = Integer.min(diff, max-i);
        }
        return max-diff;
    }

    private static int findMax(final int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            max = Integer.max(max,i);
        }
        return max;
    }
}
