package com.test.prs.challenges.hackerearth.paypal;

import java.util.Scanner;


public class TestSolution {

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);    // Writing output to STDOUT
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            Integer num = s.nextInt();
            String palindrome = getPalindrome(String.valueOf(num));
            System.out.println(getMaxOccurence(palindrome));
        }


        // Write your code here

    }

    private static int getMaxOccurence(final String palindrome) {
        int[] freq = new int[10];
        for (int i = 0; i < palindrome.length()-1; i++) {
            int digit = palindrome.charAt(i)-'0';
            freq[digit]++;
        }
        int maxFreq = 0;
        int index = 0;
        for (int j = 0; j < 10; j++) {
            if (freq[j]>maxFreq){
                maxFreq = freq[j];
                index = j;
            }
        }
        return index;
    }

    private static String getPalindrome(final String num) {
        String res = num;
        for (int i = num.length()-1; i >=0 ; i--) {
            res+=num.charAt(i);
        }
        return res;
    }
}
