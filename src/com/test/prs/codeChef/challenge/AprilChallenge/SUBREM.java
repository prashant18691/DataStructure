package com.test.prs.codeChef.challenge.AprilChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class SUBREM {

    long val;
    List<SUBREM> childs;

    public SUBREM(final long val) {
        this.val = val;
        this.childs = new ArrayList<>();
    }

    public void addChilds(SUBREM child){
        childs.add(child);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            Map<Integer,SUBREM> map = new HashMap<>();
            int n = s.nextInt();
            long x = s.nextLong();
            for (int j = 1; j <= n; j++) {
                map.put(j,new SUBREM(s.nextLong()));
            }
            for (int k = 1; k < n; k++) {
                map.get(s.nextInt()).addChilds(map.get(s.nextInt()));
            }
            System.out.println(solve(map.get(1),new HashSet<SUBREM>(),x));
        }
    }

    private static long solve(SUBREM subrem, Set<SUBREM> visited, long x) {
        long profit = subrem.val;
        if (!visited.contains(subrem)){
            visited.add(subrem);
            for (SUBREM child : subrem.childs){
                profit+=solve(child,visited,x);
            }
        }
        return Long.max(profit,-x);
    }
}
