package com.test.prs.challenges.chargebee;

public class TestCode {
    static int what_do_i_do(char str[], int i, int j, int n) {
        int res;
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        res = what_do_i_do(str, i + 1, j, n - 1) +  what_do_i_do(str, i, j - 1, n - 1) -
                what_do_i_do(str, i + 1, j - 1, n - 2);
        if (str[i] == str[j]) {
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(what_do_i_do(s.toCharArray(),0,4,5));
    }
}
