package com.test.prs.hackerrank;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestSolution {
    public static void main(String[] args) {
        Scanner s =  new Scanner(System.in);
        List<String> list = IntStream.range(0,s.nextInt()).mapToObj(i -> s.next()).collect(Collectors.toList());
        IntStream.range(0,s.nextInt()).mapToObj(i->s.next()).mapToLong(q->list.stream().filter(q::equals).count()).forEach(System.out::println);
    }
}
