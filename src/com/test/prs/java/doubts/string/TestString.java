package com.test.prs.java.doubts.string;

import java.util.ArrayList;
import java.util.List;

public class TestString {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1000);
        list.add(1000);
        if (list.get(0)==list.get(1))
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }
}
