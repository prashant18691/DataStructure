package com.test.prs.challenges.freshworks;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SumNumbers {
    public static String sum(String a, String b){
        if (a==null && b==null)
            return "0";
        int n_a = a.length();
        int n_b = b.length();
        if (n_a==0 && n_b==0)
            return "0";
        if (n_a==0)
            return b;
        else if (n_b==0)
            return a;
        int carry = 0;
        int diff = n_a-n_b;
        StringBuilder sb = new StringBuilder("");
        for ( int i = n_b-1; i >=0; i--) {
            int p = Integer.parseInt(String.valueOf(a.charAt(i+diff)));
            int q = Integer.parseInt(String.valueOf(b.charAt(i)));
            int sum = p+q+carry;
            sb.append(sum%10);
            carry = sum/10;
        }

        for (int j = n_a-n_b-1; j >=0; j--) {
            int p = Integer.parseInt(String.valueOf(a.charAt(j)));
            int sum = p+carry;
            sb.append(sum%10);
            carry = sum/10;
        }

        if (carry>0)
            sb.append(carry);


        return sb.reverse().toString();
    }

    public static String solve(String a,String b){
        if (a.length()>=b.length())
            return sum(a,b);

        return sum(b,a);
    }

   /* public static void main(String[] args) {
        System.out.println(solve("3332222221111","7777555511111111"));
    }*/
    @Test
    public void check(){
        Assert.assertEquals("7780887733332222",solve("3332222221111","7777555511111111"));
    }
}
