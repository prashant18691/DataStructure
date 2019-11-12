package com.test.prs.codeChef.challenge.MayChallenge;

import java.util.Scanner;


public class MATCHS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            long n = s.nextLong();
            long m = s.nextLong();
            System.out.println(play(n,m,true)?"Ari":"Rich");
        }
    }

    private static boolean play(long n, long m, boolean player) {
        if (n<m){
            long t = n;
            n = m;
            m = t;
        }
        return outcome(n,m,player);
    }

    private static boolean outcome(long n, long m, boolean player) {
        /*if (n==0l || m==0l)
            return !player;*/
        long q = n/m;
        long r = n%m;
        if (r==0l || q>1)
            return player;
        return outcome(m,r,!player);
    }
}
