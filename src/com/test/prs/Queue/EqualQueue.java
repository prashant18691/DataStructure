package com.test.prs.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class EqualQueue {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size1 = s.nextInt();
        int size2 = s.nextInt();
        int size3 = s.nextInt();
        int total1=0,total2=0,total3=0;
        Queue<Integer> stack1 = new LinkedList<>();
        Queue<Integer> stack2 = new LinkedList<>();
        Queue<Integer> stack3 = new LinkedList<>();
        for (int i = 0; i < size1; i++) {
            int value = s.nextInt();
            stack1.add(value);
            total1+=value;
        }
        for (int i = 0; i < size2; i++) {
            int value = s.nextInt();
            stack2.add(value);
            total2+=value;
        }
        for (int i = 0; i < size3; i++) {
            int value = s.nextInt();
            stack3.add(value);
            total3+=value;
        }

        while (!(total1==total2 && total2==total3 && total3==total1)){
            if (total1>total2 && total1>total3)
                total1-=stack1.poll();
            else if (total2>total1 && total2>total3)
                total2-=stack2.poll();
            else
                total3-=stack3.poll();
        }
        System.out.println(total1);
    }
}
