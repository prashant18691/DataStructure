package com.test.prs.challenges.hackerearth;

import java.util.Scanner;

public class TestSpecialString {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        String text = s.nextLine();
        int n = text.length();
        int spCount = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(solve(text.substring(i,j)))
                    spCount++;
            }
        }
        System.out.println(spCount);
    }

    public static boolean solve(String text){
        int n = text.length();
        if(n==0)
            return false;
        if(n==1)
            return true;
        int count = 1;
        for(int i=0;i<n-1;i++){
            if(text.charAt(i)==text.charAt(i+1))
                count++;
        }
        if(count==n)
            return true;
        else{
            if(n%2!=0){
                int mid = (n-1)/2;
               for(int i=0;i<mid;i++)
                   if(text.charAt(i)!=text.charAt(n-i-1))
                       return false;
               return true;

            }
        }
        return false;
    }
}

