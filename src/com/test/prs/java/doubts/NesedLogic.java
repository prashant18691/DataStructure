package com.test.prs.java.doubts;

import java.util.Scanner;

public class NesedLogic {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int d2 = s.nextInt();
        int m2 = s.nextInt();
        int y2 = s.nextInt();
        int d1 = s.nextInt();
        int m1 = s.nextInt();
        int y1 = s.nextInt();

        if(y2>y1){
            System.out.println(10000);
            return;
        }
        else {
            if (y2 == y1) {
                if (m2 > m1) {
                    System.out.println((m2 - m1) * 500);
                    return;
                } else {
                    if (m2==m1) {
                        if (d2 > d1) {
                            System.out.println((d2 - d1) * 15);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(0);

    }
}
