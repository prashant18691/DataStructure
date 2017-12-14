package com.test.prs.challenges;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String,String> m = new HashMap<>();
        m.put("A","A");
        m.put(new String("A"),"B");
        for(Map.Entry<String,String > eachM : m.entrySet())
            System.out.println(eachM.getKey()+" "+eachM.getValue());
        System.out.println("A".hashCode());
        System.out.println(new String("A").hashCode());
        Collections.sort(new ArrayList<>(m.entrySet()), new Comparator<Map.Entry<String,String>>() {
            @Override
            public int compare(Map.Entry<String,String> o1, Map.Entry<String,String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
    }
}
