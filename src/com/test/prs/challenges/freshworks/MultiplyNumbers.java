package com.test.prs.challenges.freshworks;

public class MultiplyNumbers {

    public static String product(String a , String b){
        int n = a.length();
        int m = b.length();
        if (n==0 || m==0)
            return "0";
        int[] sum = new int[n+m];
        int n_a=0,n_b=0;
        for (int i = a.length()-1; i >=0; i--) {
                int p = Integer.parseInt(String.valueOf(a.charAt(i)));
                int carry = 0;
                n_b = 0;
            for (int j = b.length()-1; j >=0; j--) {
                int q = Integer.parseInt(String.valueOf(b.charAt(j)));
                int product = p*q + sum[n_a+n_b] + carry;
                carry = product/10;
                sum[n_a+n_b] = product%10;
                n_b++;
            }
            if (carry>0)
                sum[n_a+n_b]+=carry;
            n_a++;
        }
        int i = sum.length-1;
        while (i>=0 && sum[i]==0)
            i--;
        if (i==-1)
            return "0";
        String s = "";
        while (i>=0)
            s+=sum[i--];
        return s;
    }


    public static void main(String[] args) {
        System.out.println(product("178","12"));
    }
}
