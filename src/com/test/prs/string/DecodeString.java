package com.test.prs.string;

import java.util.Stack;

public class DecodeString {
    public static String  decodeString(String s) {
        if(s==null || s.length()==0) return null;
        Stack<String> strStack = new Stack<>();
        Stack<Integer> frqStack = new Stack<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='[')
                continue;
            else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                StringBuffer sb = new StringBuffer("");
                while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9')
                    sb.append(s.charAt(i++));
                i--;
                frqStack.push(Integer.parseInt(sb.toString()));
            }
            else if(s.charAt(i)>=97 && s.charAt(i)<=122){
                StringBuffer sb = new StringBuffer("");
                while(i<n && s.charAt(i)>=97 && s.charAt(i)<=122)
                    sb.append(s.charAt(i++));
                i--;
                strStack.push(sb.toString());
            }
            else if(s.charAt(i)==']'){
                int count = 1;String value = null;
                if(!frqStack.isEmpty())
                    count = frqStack.pop();
                if(!strStack.isEmpty())
                    value = strStack.pop();
                String decoded = "";
                while(count>0){
                    decoded+=value;
                    count--;
                }
                strStack.push(decoded);
            }
        }
        StringBuffer res = new StringBuffer();
        while(!strStack.isEmpty())
            res.append(strStack.pop());

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
