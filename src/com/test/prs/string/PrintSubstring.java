package com.test.prs.string;

public class PrintSubstring {
    public static  void printSubstring(String s){
        int length = s.length();
        for(int i=0; i<length;i++){
            StringBuilder c = new StringBuilder();
            c.append(s.charAt(i));
            for(int j=i+1; j<=length;j++){
                System.out.println(c.toString());
                if(j<length)
                    c.append(s.charAt(j));
            }
        }
    }

    public static void printSubstring1(String s){
        int length = s.length();

        for(int i=0; i<length;i++){
            for(int j=i+1;j<=length;j++){
                System.out.println(s.substring(i,j));
            }
        }
    }

    public static void main(String[] args) {
        printSubstring("THIS IS A STRING");
        System.out.println("********");
        printSubstring1("ABC");
    }
}
