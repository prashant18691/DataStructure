package com.test.prs.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestSolution {
    public static void main(String[] args) {
        /*Scanner s =  new Scanner(System.in);
        List<String> list = IntStream.range(0,s.nextInt()).mapToObj(i -> s.next()).collect(Collectors.toList());*/
        int[] arr = new int[3];
        Supplier<Integer> supply1 = ()->1;
        Arrays.stream(arr).map(i->supply1.get());
        Arrays.stream(arr).forEach(System.out::println);
        String[] strArr = new String[]{};
        int[] a = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
//        IntStream.range(0,s.nextInt()).mapToObj(i->s.next()).mapToLong(q->list.stream().filter(q::equals).count()).forEach(System.out::println);
        System.out.println(System.currentTimeMillis());
    }
}
