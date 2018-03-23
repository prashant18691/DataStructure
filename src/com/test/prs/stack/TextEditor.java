package com.test.prs.stack;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder s = new StringBuilder("");
        Stack<String> stack = new Stack<>();
        for(int i=0;i<n;i++){
            int op = Integer.parseInt(sc.next());
            if(op==1){
                stack.push(s.toString());
                s.append(sc.next());
            }
            else if(op==2){
                if(s.length()>0)
                {
                    int num = Integer.parseInt(sc.next());
                    int y = s.length()-1;
                    stack.push(s.toString());
                    while(s.length()>0 && num>0){
                        s.deleteCharAt(y--);
                        num--;
                    }
                }
            }
            else if(op==3){
                int k = Integer.parseInt(sc.next());
                if(s.length()>0 && k<=s.length())
                    System.out.println(s.charAt(k-1));
            }
            else if(op==4){
                s = new StringBuilder(stack.pop());
            }
        }
    }
}
