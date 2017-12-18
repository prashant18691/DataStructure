package com.test.prs.stack;

import java.util.Scanner;
import java.util.Stack;

public class TestBalancedString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
    public static boolean isBalanced(String str) {
        Stack<Character> s = new Stack<Character>();
        for(int i=0;i<str.length();i++){
            Character c = str.toCharArray()[i];
            if(c.equals('{')||c.equals('(')||c.equals('['))
                s.push(c);
            else{
                if(s.isEmpty())
                    return false;
                else {
                    Character poppedC = s.pop();
                    if (c.equals('}') && !poppedC.equals('{'))
                        return false;
                    if (c.equals(')') && !poppedC.equals('('))
                        return false;
                    if (c.equals(']') && !poppedC.equals('['))
                        return false;
                }
            }
        }
        return s.isEmpty();
    }
}
