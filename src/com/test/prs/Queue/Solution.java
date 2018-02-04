package com.test.prs.Queue;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            return peekOrPop("peek");
        }

        public T dequeue() {
            return peekOrPop("pop");
        }

        private T peekOrPop(String opr){
            if(stackOldestOnTop.size()==0){
                int size = stackNewestOnTop.size();
                if(size==1)
                    return checkOperation(stackNewestOnTop,opr);
                for(int i = 0;i<size;i++){
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
            return checkOperation(stackOldestOnTop,opr);
        }

        private T checkOperation(Stack<T> stack,String opr){
            if(opr.equals("pop"))
                return stack.pop();
            else
                return stack.peek();

        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
