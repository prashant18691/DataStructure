package com.test.prs.challenges.fourkites;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;


public class IndexOfGivenStringInASubstring {

    public int solve(String str){
        int index = -1;
        if (str==null || str.length()==0)
            return index;
        int n = str.length();
        SortedSet<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++)
            for (int j = i+1; j <= n; j++)
                set.add(str.substring(i, j));
        List<String> list = new ArrayList<>(set);
        index = list.indexOf(str);
        if (index!=-1)
            return ++index;

        return index;
    }

    public static void main(String[] args) {
        IndexOfGivenStringInASubstring test = new IndexOfGivenStringInASubstring();
        System.out.println(test.solve("acb"));
        Graph g = new Graph();
    }

    static class Graph{

    }
}
