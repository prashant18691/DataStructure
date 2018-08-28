package com.test.prs.spoj;

import java.util.*;
import java.lang.*;

public class ReversePolishNotation
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
            String exp = s.next();
            System.out.println(getRPS(exp,exp.length()));
            t--;
        }

    }
    static boolean isLetter(char c){
        return Character.isLetter(c);
    }
    static String getRPS(String exp, int n){
        Stack<Character> ops = new Stack<Character>();
        StringBuffer rps = new StringBuffer("");
        char[] expCharArray = exp.toCharArray();
        for(int i=0;i<n;i++){
            if(expCharArray[i]=='('){
                ops.push(expCharArray[i]);
                continue;
            }
            if(expCharArray[i]==')'){
                while(ops.peek()!='(')
                    rps.append(ops.pop());
                ops.pop();
                continue;
            }
            if(expCharArray[i]=='+' || expCharArray[i]=='-' || expCharArray[i]=='/' || expCharArray[i]=='*'
                    || expCharArray[i]=='^'){
                while(!ops.isEmpty() && hasPrecedence(expCharArray[i],ops.peek()))
                    rps.append(ops.pop());
                ops.push(expCharArray[i]);
                continue;
            }
            if(isLetter(expCharArray[i])){
                rps.append(expCharArray[i]);
                continue;
            }
        }
        while(!ops.isEmpty()){
            rps.append(ops.pop());
        }
        return rps.toString();
    }

    static boolean hasPrecedence(char current, char stackTop){
        if(stackTop=='(' || stackTop==')')
            return false;
        if((current=='*' || current=='/') && (stackTop=='+' || stackTop=='-'))
            return false;
        if (current=='^' && (stackTop=='+' || stackTop=='-' || stackTop=='/' || stackTop=='*'))
            return false;
        if(current=='/' && stackTop=='*')
            return false;
        return true;
    }
}
