package com.test.prs.stack;

import java.util.Stack;

public class FindNextGreatest {
    public  static void findNextGreatest(int[] arr){
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (s.isEmpty() || s.peek()>arr[i])
                s.push(arr[i]);
            else{
                while(!s.isEmpty() && s.peek()<arr[i])
                    System.out.println(s.pop()+" : "+arr[i]);
                s.push(arr[i]);
            }
        }
        while (!s.isEmpty())
            System.out.println(s.pop()+" : "+-1);
    }

    public static void main(String[] args) {
        int[] arr = {40,50,11,32,55,68,75};
        findNextGreatest(arr);
    }
}
