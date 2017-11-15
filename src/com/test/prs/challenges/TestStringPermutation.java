package com.test.prs.challenges;

public class TestStringPermutation {
    private static void  createStrPerm(int n) {
        String[] set = {"a", "b"};
        int k = set.length;
        createStrPermRec(set, "", n, k);// n length of string to be generated; k length of set
    }

    private static void createStrPermRec(String[] set, String prefix, int n, int k) {
        if(n==0) {
            System.out.println(prefix);
            return;
        }
        for(int i=0;i<k;i++){
            String newPrefix = prefix+set[i];
            createStrPermRec(set,newPrefix,n-1,k);
        }
    }

    private static boolean checkPalindrome(String s) {
        String reverse = isPalindrome(s);
        return reverse.equals(s);
    }

    private static String isPalindrome(String s) {
        int length = s.length();
        if(length==1)
            return s;
        String last= s.substring(length-1);
        return last+isPalindrome(s.substring(0,length-1));
    }


    public static void main(String[] args){
//        createStrPerm(3);
        System.out.println(checkPalindrome("abb"));
    }
}
