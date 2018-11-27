package com.test.test;

import java.util.List;


public class TestCurrency {
    public static void main(String[] args) {
        /*String amount = "16.99";
        BigDecimal a = new BigDecimal(amount);
        BigDecimal round = BigDecimal.valueOf(1);
        BigDecimal precision = BigDecimal.valueOf(100);
        BigDecimal disputeAmt = a.multiply(precision.divide(round));
        System.out.println(disputeAmt.longValue());*/
        double a = 16.99;
        double b = a * new Double(100);
        System.out.println(b);
    }
}
