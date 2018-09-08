package com.test.prs.spoj;

import java.util.Arrays;
import java.util.Scanner;


public class NextPalindrome {

    /*public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int t = s.nextInt();
       while(t>0){
           getNextPalindrome(s.next());
           System.out.println();
           t--;
       }
    }

    private static int[] getIntArray(final String num) {
        int n = num.length();
        int[] intNum = new int[n];
        for (int i = 0; i < n; i++) {
            intNum[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return intNum;
    }


    public static void getNextPalindrome(String num){
        if (num==null || num.length()==0){
            return;
        }
        int n = num.length();
        if (isAll9(num)){
            StringBuilder sb = new StringBuilder("");
            sb.append("1");
            for (int i = 0; i < n-1; i++) {
                sb.append("0");
            }
            sb.append("1");
            System.out.println(sb.toString());
        }
        else{
            getNextPalindrome(getIntArray(num), n);
        }
    }

    private static void getNextPalindrome(int[] num, final int n) {
        boolean isEven = n%2==0?true:false;
        int mid = n/2;
        int i = mid-1;
        int j = isEven?mid:mid+1;

        while (i>=0 && num[i]==num[j]){// ignore the elements between i & j which are already a palindrome
            i--;j++;
        }
        boolean isPalindromeOrSmallerLeftSide = false;
        if (i<0 || num[i]<num[j]){ // if i<0 then given num is a palindrome so need to add one to middle element(s)
             isPalindromeOrSmallerLeftSide = true;  // num[i]<num[j] --> smaller left side
        }
        while(i>=0){// copy the mirror of left side to right side if num is not a palindrome
            num[j++] = num[i--];
        }

        if (isPalindromeOrSmallerLeftSide){
            int carry = 1;
            if (!isEven){// if odd increment the middle element and store carry
                num[mid]+=carry;
                carry = num[mid]/10;
                num[mid] %= 10;
            }
            i = mid-1;
            j = isEven?mid:mid+1;
            while(i>=0){
                num[i]+=carry;
                carry = num[i]/10;
                num[i] %= 10;
                num[j++]=num[i--];
            }
        }
        for (int k = 0; k < n; k++) {
            System.out.print(num[k]);
        }
    }

    private static boolean isAll9(final String num) {
        int i = 0;
        int j = num.length()-1;
        while(i<=j){
            if (num.charAt(i)=='9' && num.charAt(i++)==num.charAt(j--)){
                continue;
            }
            return false;
        }
        return true;
    }*/


    //second method

    public static void main(String[] args) {

        int num[]= {1,2,3,4};
        if(isAll9(num)) {
            System.out.print("1");
            for (int i = 0; i < num.length - 1; i++)
                System.out.print("0");
            System.out.println("1");
            return;
        }
        if(is_Palindrome(num)) {
            num[num.length-1]++;
        }
        for(int i=0,j=num.length-1;i<j;i++,j--)
        {
            if(num[i]>=num[j])
                num[j]=num[i];
            else {
                num[j-1]++;
                if(num[j-1]==10) {
                    num[j-1]=0;
                    num[j-2]++;
                }
                num[j]=num[i];
            }
        }
        System.out.println(Arrays.toString(num));

    }
    public static boolean is_Palindrome(int[] arr)
    {
        for(int i=0,j=arr.length-1;i<j;i++,j--) {
            if(arr[i]!=arr[j])
                return false;
        }
        return true;
    }
    public static boolean isAll9(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]!=9)
                return false;
        }
        return true;
    }
}

