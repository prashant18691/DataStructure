package com.test.prs.gcd;

import java.util.Scanner;

public class FindGCD {
    public static int findGCD(int a, int b){
        while(a!=b){
            if(a>b)
                a-=b;
            else
                b-=a;
        }
        return a;
    }

    public static MaxAB findMaxGCDNaive(int[] a, int[] b, int n){
        int maxGCD = Integer.MIN_VALUE; MaxAB max = new MaxAB(0,0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int gcd = findGCD(a[i],b[j]);
                if(maxGCD<gcd) {
                    maxGCD = gcd;
                    max.a = a[i];
                    max.b = b[j];
                }
            }
        }
        return max;
    }

    private static class MaxAB{
        public MaxAB(int a, int b) {
            this.a = a;
            this.b = b;
        }

        int a,b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        for(int A_i = 0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        int[] B = new int[n];
        for(int B_i = 0; B_i < n; B_i++){
            B[B_i] = in.nextInt();
        }
        MaxAB res = findMaxGCDNaive(A, B,n);
        System.out.println(res.a+res.b);
    }
    }

