package com.test.prs.java.doubts.lamda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestMapLamda {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("Fruits", Arrays.asList("Orange","Apple","Guava"));
        map.put("Veggies", Arrays.asList("Apple","Onion","Lettuce"));
        map.put("Dessert", Arrays.asList("Pastry","Apple", "Cream"));
        //print all apples
        map.entrySet().stream().forEach(e -> e.getValue().stream().filter(a -> a.equals("Apple")).forEach(
                System.out::println
        ));
        //print category + all apples
        map.entrySet().stream().forEach(e -> e.getValue().stream().filter(a -> a.equals("Apple")).forEach(
                a -> System.out.println(e.getKey() + " "+a)
        ));



        List<String> alpha = Arrays.asList("a", "b", "c", "d");
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.forEach(System.out::println);

        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(k -> k * 2).collect(Collectors.toList());
        collect1.stream().forEach(a-> System.out.println(a));

        List<Staff> staff = Arrays.asList(
                new Staff("mkyong", 30, new BigDecimal(10000)),
                new Staff("jack", 27, new BigDecimal(20000)),
                new Staff("lawrence", 33, new BigDecimal(30000))
        );

        Predicate<String> isMykong = a -> "mykong".equals(a);

        List<StaffPublic> only_for_mkyong = staff.stream().map(staff1 -> {
            StaffPublic staffPublic = new StaffPublic(staff1.getName(), staff1.getAge(), null);
            if (isMykong.test(staff1.getName()))
                staffPublic.setExtra("Only for mkyong");
            return staffPublic;
        }).collect(Collectors.toList());

        int XOR = 1;
        System.out.println(~XOR);

    }
}
