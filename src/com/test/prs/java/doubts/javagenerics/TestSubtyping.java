package com.test.prs.java.doubts.javagenerics;

import java.util.*;

public class TestSubtyping {
    public static void main(String[] args) {
        //List<Number> list = new ArrayList<Integer>(); no subyping allowed
//        List<Integer>[] array = new ArrayList<Integer>[10];
        int[] t = new int[2];
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        /*for(Integer i :list)
        {
            System.out.println(i);
            if(i.equals(3))
                list.add(4);

        }*/
        ListIterator<Integer> itr = list.listIterator();
        while(itr.hasNext()){
            Integer i = itr.next();
            System.out.println(i);
            if(i.equals(2))
                itr.add(4);
        }
        for(int i : list)
            System.out.println(i);

    }
}
