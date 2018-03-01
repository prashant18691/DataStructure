package com.test.prs.string;

import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        System.out.println(evaluate("51*55/(2+3)"));
    }
    public static int  evaluate(String exp){
        Stack<Character> ops = new Stack<>();
        Stack<Integer> values = new Stack<>();
        char[] expCharArr = exp.toCharArray();
        for (int i = 0; i < expCharArr.length; i++) {
            if (expCharArr[i]==' ')
                continue;
            if (expCharArr[i]=='(')
                ops.push(expCharArr[i]);
            else if (expCharArr[i]>='0' && expCharArr[i]<='9'){
                StringBuffer sb = new StringBuffer();
                while(i<expCharArr.length && expCharArr[i]>='0' && expCharArr[i]<='9')
                    sb.append(expCharArr[i++]);
                i--;
                values.push(Integer.parseInt(sb.toString()));
            }
            else if (expCharArr[i]==')'){
                while (ops.peek()!='(')
                    values.push(applyOps(ops.pop(),values.pop(),values.pop()));
                ops.pop();
            }
            else if (expCharArr[i]=='+' || expCharArr[i]=='-' || expCharArr[i]=='*' || expCharArr[i]=='/'){
                while (!ops.isEmpty() && hasPrecedence(expCharArr[i],ops.peek()))
                    values.push(applyOps(ops.pop(),values.pop(),values.pop()));
                ops.push(expCharArr[i]);
            }
        }
        while (!ops.isEmpty())
            values.push(applyOps(ops.pop(),values.pop(),values.pop()));

        return values.pop();
    }

    private static boolean hasPrecedence(char currOps, char stackOps) {
        if (stackOps=='(' || stackOps==')')
            return false;
        if ((currOps=='*' || currOps=='/') && (stackOps=='+' || stackOps=='-'))
            return false;
        if (currOps=='/' && stackOps=='*')
            return false;
        return true;
    }

    private static Integer applyOps(Character ops, Integer b, Integer a) {
        switch (ops){
            case '+':{
                return a+b;
            }
            case '-':{
                return a-b;
            }
            case '*':{
                return a*b;
            }
            case '/':{
                if (b==0)
                    throw new ArithmeticException("Divide by 0");
                return a/b;
            }
        }
        return -1;
    }
}
