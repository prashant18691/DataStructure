package com.test.prs.map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestMap {
    @Test
    public void testMyMapTest(){
        MyMap<String, Integer> map = new MyMap<String, Integer>();
        map.put("Lars", 1);
        map.put("Lars", 2);
        map.put("Lars", 1);
        assertEquals(String.valueOf(map.get("Lars")), String.valueOf(1));
        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i), i);
        }
        assertEquals(map.size(), 101);
        assertEquals(String.valueOf(map.get("51")), String.valueOf(51));

        map.remove("Lars");
        assertNull(map.get("Lars"));
        assertEquals(map.size(),100);
    }

   /* public static void main(String[] args) {
        MyMap<String, Integer> map = new MyMap<String, Integer>();
        map.put("Lars", 1);
        map.put("Lars", 2);
        map.put("Lars", 1);
        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i), i);
        }
        System.out.println(map.size());
    }*/
}
