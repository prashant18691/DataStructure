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
            int curr = in.nextInt();
            int low = 0;
            int high = theList.size()-1;
            while(low<=high){
                int median = (low+high)/2;
                if(curr>=theList.get(median)){
                    low = median+1;
                    if(low<=high && curr<=theList.get(low))
                        high = low;
                }
                else{
                    high = median-1;
                    if(high>0 && curr>=theList.get(high))
                        low = high;
                }
            }
            theList.add(low,curr);
            System.out.println(String.format("%.1f",getMedianValue(theList)));
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
