package com.test.prs.challenges;

public class TestException1 {
   public static void main(String[] args){
       try{
        int a = 9/0;
       }
       catch(Exception e){
           System.out.println("catch");// exception handling
       }
       finally {
           System.out.println("finally");
       }
       System.out.println("end");
   }
}
