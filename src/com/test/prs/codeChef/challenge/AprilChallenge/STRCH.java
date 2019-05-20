package com.test.prs.codeChef.challenge.AprilChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class STRCH {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(r.readLine());
            String[] ip = r.readLine().split(" ");
            String str = ip[0];
            String x = ip[1];
            System.out.println(find(str,x,n));
        }
    }

    private static int solve(final String str, final String x, final int n) {//inefficient
        int c = 0;
        int i = 0;
        int j=i+1;
        while(i<n) {
            if (j<=n) {
                if (str.substring(i,j).contains(x)) {
                    c++;
                }
                j++;
            }
            else{
                i++;
                j=i+1;
            }
        }
        return c;
    }

    private static long find(final String str, final String x, final int n) {
        long c = 0l;
        int i = -1;
        for (int j = 0; j < n; j++) {
            if (String.valueOf(str.charAt(j)).equals(x)) {
                c+=(j-i)*(n-j);
                i=j;
            }
        }
        return c;
    }

}
