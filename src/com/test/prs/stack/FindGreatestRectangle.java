package com.test.prs.stack;

import java.util.Scanner;
import java.util.Stack;

public class FindGreatestRectangle {

    static long largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack<>();
        long max_area =Integer.MIN_VALUE;
        int area = 0;
        int i=0;
       while(i<h.length){
           if (stack.isEmpty() || h[i]>=h[stack.peek()])
               stack.push(i++);
           else{
               int top = stack.pop();
               if (stack.isEmpty())
                 area = h[top]*i;
               else
                 area = h[top]*(i-stack.peek()-1);
               if (max_area<area)
                   max_area = area;
           }
        }
    while (!stack.isEmpty()) {
        int top = stack.pop();
        if (stack.isEmpty())
            area = h[top] * i;
        else
            area = h[top] * (i - stack.peek() - 1);
        if (max_area < area)
            max_area = area;
    }

        return max_area;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        for(int h_i = 0; h_i < n; h_i++){
            h[h_i] = in.nextInt();
        }
        long result = largestRectangle(h);
        System.out.println(result);
        in.close();
    }
}

