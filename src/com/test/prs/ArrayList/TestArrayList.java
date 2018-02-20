package com.test.prs.ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        printlist(list); //implement iterator
        list.remove(2);
        System.out.println("***********");
        printlist(list);

    }

    private static void printlist(MyArrayList list) {
        MyIterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
