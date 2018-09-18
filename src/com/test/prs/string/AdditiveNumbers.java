package com.test.prs.string;

public class AdditiveNumbers {
    public static boolean isAdditive(String str){
        if (str.length()<3)
            return false;
        for (int i = 1; i <= str.length()/2; i++) {//number of digits of sum cannot be less than any
            for (int j = 1; j <= (str.length()-i)/2; j++) {// of two operands
                 if (!checkAdditiveness(str.substring(0,i),str.substring(i,j+i),str.substring(i+j)))
                     continue;
                 return true;
            }
        }
        return false;
    }

    private static boolean checkAdditiveness(String a, String b, String c) {
        if (!isValid(a) || !isValid(b))
            return false;
        String sum = getSum(a,b);
        if (sum.equals(c))
            return true;
        if (c.startsWith(sum)){
            return checkAdditiveness(b,sum,c.substring(sum.length()));
        }
        else
            return false;
    }

    private static String getSum(String a, String b) {
        StringBuilder sum = new StringBuilder("");
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        int t = 0;
        while (i>=0 && j>=0){
            t = (a.charAt(i)-'0')+(b.charAt(j)-'0') + carry;
            carry = t/10;
            sum.append(String.valueOf(t%10));
            i--;j--;
        }
        while (i>=0) {
            t = (a.charAt(i--)-'0')+carry;
            carry =t/10;
            sum.append(String.valueOf(t%10));
        }
        while (j>=0) {
            t = (b.charAt(j--)-'0')+carry;
            carry =t/10;
            sum.append(String.valueOf(t%10));
        }

        if (carry!=0 && i<0 && j<0)
            sum.append(String.valueOf(carry));
        return String.valueOf(sum.reverse());
    }

    private static boolean isValid(String num) {
        if (num.length()>1 && num.charAt(0)=='0')
            return false;
        return true;
    }

    public static void main(String[] args) {
        String num1 = "199100199";
        System.out.println(isAdditive(num1));
    }
}
