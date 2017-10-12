package com.test.prs.challenges;

import java.util.*;

public class TestCustomSorting {
    static List<String> dictionary = Arrays.asList(new String[]{"Orange", "Apple", "Pineapple", "Grape"});

    void dictionaryBasedSorting(String[] input){
        if(input==null)
            return;
        List<ABC> list = new ArrayList<>();
        for(int i=0;i<input.length;i++){
            int index = dictionary.indexOf(input[i]);
            if(index>=0){
                list.add(new ABC(input[i],index));
            }
        }
        Collections.sort(list,new CustomComparator());
        for(ABC a : list)
            System.out.println(a.getName());
    }

    public static void main(String[] args){
        TestCustomSorting test = new TestCustomSorting();
        test.dictionaryBasedSorting(new String[]{"Apple","Grape","Pineapple"});
    }
}

class CustomComparator implements Comparator<ABC>{
    @Override
    public int compare(ABC o1, ABC o2) {
        return o1.index-o2.index;
    }
}

class ABC{
    String name;
    int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ABC(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
