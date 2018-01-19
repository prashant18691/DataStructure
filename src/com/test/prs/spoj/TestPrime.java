package com.test.prs.spoj;

/* package whatever; // don't place package name! */

import java.util.Scanner;

/* Name of the class has to be "Main" only if the class is public. */
class TestPrime
{

    public static void main (String[] args) throws java.lang.Exception
    {

        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        while(t>0){
            int m = s.nextInt();
            int n = s.nextInt();
            while(m<n){
                if(isPrime(m))
                    System.out.println(m);
                m++;
            }
            while(m<=n){
                if(isPrime(n))
                    System.out.println(n);
                n--;
            }
            t--;
            System.out.println();
        }
    }

    public static boolean isPrime(int n){
        if(n<=1)
            return false;
        for(int i=2;i<Math.floor(Math.sqrt(n)+1);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
