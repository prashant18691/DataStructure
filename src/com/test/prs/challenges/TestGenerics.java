package com.test.prs.challenges;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {

    public void testGenerics(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        test(list);
    }
    void test(List list){
        list.add("a");
        for(Object s : list)
            System.out.println(s);
    }

    public static void main(String[] args) {
        TestGenerics g = new TestGenerics();
        g.testGenerics();
    }
}
