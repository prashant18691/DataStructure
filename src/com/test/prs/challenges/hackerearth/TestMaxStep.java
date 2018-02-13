package com.test.prs.challenges.hackerearth;

import java.util.Scanner;

public class TestMaxStep {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long q = s.nextLong();
        long[] a = new long[100001];
        for(int i=0;i<n;i++)
            a[i] = s.nextLong();
        for(int i=0;i<q;i++){
            long k = s.nextLong();
            int count = 0;
            for(int j=0;j<n;j++){
                long f = smallestFactor(a[j]);
                while (k>0 && a[j]/f>=1)
                {
                    a[j]/=f;
                    k--;
                }
                if(a[j]==1)
                    count++;
                if(k<1)
                    break;
            }
            System.out.println(count);
        }

    }


    public static long smallestFactor(long C)
    {
        for (int i = 2; i*i<= C; i++)
        {
            if (C % i == 0)
            {
                return i;
            }
        }

        return C;
    }
}
