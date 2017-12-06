package com.test.prs.codeChef.challenge;

import java.util.Arrays;
import java.util.Scanner;

public class FindPrimeDiff {

    static boolean[] primes = new boolean[1000001];
    public FindPrimeDiff(){
        Arrays.fill(primes,true);
        primes[0]=false;
        primes[1]=false;
        for(int i=2;i<primes.length;i++){
            if(primes[i]){
                for(int j=2;i*j<primes.length;j++)
                    primes[i*j]=false;
            }
        }
    }

    static int maxDifference(int startVal, int endVal) {
        if(startVal==endVal)
            return 0;
        int lowest=Integer.MAX_VALUE;
        int largest=Integer.MIN_VALUE;

       while(startVal<endVal){
           if(primes[startVal]){
               lowest=startVal;
               startVal++;
               break;
           }
           else{
               startVal++;
           }
       }
       while(endVal>startVal){
           if(primes[endVal]){
               largest=endVal;
               endVal--;
               break;
           }
           else{
               endVal--;
           }
       }
        return largest>lowest?largest-lowest:0;
    }

    static boolean isPrime(int n){
        return primes[n];
           }

    public static void main(String[] args) {
        FindPrimeDiff di = new FindPrimeDiff();
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int startVal = in.nextInt();
            int endVal = in.nextInt();
            int result = maxDifference(startVal, endVal);
            System.out.println(result);
        }
        in.close();
    }
}
