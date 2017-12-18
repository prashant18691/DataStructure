package com.test.prs.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> theList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer theValue = in.nextInt();
            int lo = 0;
            int hi = theList.size();
            while (lo < hi) {
                int median = (lo + hi) / 2;
                if (theValue >= theList.get(median)) {
                    lo = median + 1;
                    if (median + 1 < theList.size() && theValue <= theList.get(median + 1)) {
                        hi = median + 1;
                    }
                } else {
                    hi = median;
                    if (median > 0 && theValue >= theList.get(median - 1)) {
                        lo = median;
                    }
                }
            }
            theList.add(lo, theValue);
            System.out.println(String.format("%.1f", getMedianValue(theList)));
        }
    }

    public static float getMedianValue(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        } else if (list.size() % 2 == 1) {
            return list.get((list.size()) / 2);
        } else {
            return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2f;
        }
    }
}
