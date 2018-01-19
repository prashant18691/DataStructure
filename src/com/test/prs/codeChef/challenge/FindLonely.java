package com.test.prs.codeChef.challenge;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindLonely {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
            int n = s.nextInt();
            int[] in = new int[n];
            for(int i=0;i<n;i++){
                in[i] = s.nextInt();
            }
            Set<Integer> h = new HashSet<>();
            for(int i : in)
                if(!h.add(i))
                    h.remove(i);
            for(int i:h)
            System.out.println(i);
            t--;
        }
    }

}
