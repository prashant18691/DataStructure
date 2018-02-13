package com.test.prs.challenges;

public class TestMagicNumber {
    public static int findMagicNum(int n){
       int pow = 1,answer = 0;
       while (n!=0){
           pow*=5;
           if((n&1)==1)
               answer+=pow;
           n>>=1;
       }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(findMagicNum(7));
    }
}
