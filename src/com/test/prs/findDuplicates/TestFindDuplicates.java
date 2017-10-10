package com.test.prs.findDuplicates;

import java.util.Arrays;

public class TestFindDuplicates {

   void findDuplicates(int[] ip){
       for(int i=0;i<ip.length;i++){
           if(ip[Math.abs(ip[i])]>=0){
               ip[Math.abs(ip[i])] = -ip[Math.abs(ip[i])];
           }
           else
               System.out.println(Math.abs(ip[i]));
       }
   }

   void findDupes(int[] ip){
       int n = ip.length;
       for(int i=0;i<n;i++){
           ip[ip[i]%n]+=n;
       }
       System.out.println(Arrays.toString(ip));
       for(int i=0;i<n;i++){
           if(ip[i]/n>1)
               System.out.print(i+" ");
       }
   }

   public static void main(String[] args){
       TestFindDuplicates test = new TestFindDuplicates();
       int[] inp = new int[]{4, 2, 4, 5, 2, 3, 1, 4};
       test.findDupes(inp);
   }
}
