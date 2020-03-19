package com.test.prs.challenges.zalando;

import java.util.*;
import java.util.stream.Collectors;

public class PrintByFrequency {

    public static void main(String[] args) {
        String s = "My tEST is MY TEST IS the It because test";
        System.out.println(solvePuzzle(s));
    }

    static StringBuilder solvePuzzle(String s){
        StringBuilder sb = new StringBuilder("");
        Map<String,List<Integer>> countMap = new LinkedHashMap<>();

        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            if (countMap.containsKey(str[i].toLowerCase())) {
                List<Integer> w = countMap.get(str[i].toLowerCase());
                w.add(i);
            } else {
                List w = new ArrayList<>();
                w.add(i);
                countMap.put(str[i].toLowerCase(), w);
            }
        }
            List<Map.Entry<String,List<Integer>>> list = new ArrayList<>(countMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, List<Integer>>>() {
                @Override
                public int compare(Map.Entry<String, List<Integer>> t1, Map.Entry<String, List<Integer>> t2) {
                    return Integer.valueOf(t2.getValue().size()).compareTo(Integer.valueOf(t1.getValue().size()));
                }
            });

        for(Map.Entry<String,List<Integer>> entry: list){
                sb.append(entry.getValue().stream().map(x->str[x]+" ").collect(Collectors.joining())+" ");
            }
        return sb;
    }

}

