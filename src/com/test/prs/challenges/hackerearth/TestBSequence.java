package com.test.prs.challenges.hackerearth;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TestBSequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Integer[] in = new Integer[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            in[i] = s.nextInt();
            max = Math.max(in[i],max);
        }
        int max_index =Arrays.binarySearch(in,max);
        int q = s.nextInt();
        for (int i = 0; i < q; i++) {
            int o = s.nextInt();
            if(o==max)
                System.out.println(in.length);
            else if(o<max){
                if (Arrays.binarySearch(in,0,max_index,o)<0)
                {
                    in  = Arrays.copyOf(in,in.length+1);
                    in[in.length-1] = 0;
                    insertElement(in,o,max_index);
                    Arrays.sort(in,0,max_index++);
                    System.out.println(in.length);
                }
                else {
                    if (Arrays.binarySearch(in,max_index+1,in.length,o)<0){
                        in  = Arrays.copyOf(in,in.length+1);
                        in[in.length-1] = 0;
                        insertElement(in,o,max_index+1);
                        Arrays.sort(in,max_index+1,in.length, Collections.reverseOrder());
                        System.out.println(in.length);
                    }
                    else
                        System.out.println(in.length);
                }
            }
        }
        printArray(in);
    }

    private static void printArray(Integer[] in) {
        for (int i = 0; i < in.length; i++) {
            System.out.print(in[i]+" ");
        }
    }

    private static void insertElement(Integer[] in, int o, int start) {
        int max = in[start];
        in[start] = o;
        for (int i = start+1; i < in.length ; i++) {
            int temp = in[i];
            in[i] = max;
            max = temp;
        }
    }

}
