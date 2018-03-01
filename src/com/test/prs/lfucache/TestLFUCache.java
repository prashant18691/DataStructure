package com.test.prs.lfucache;

public class TestLFUCache {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(4);
        for (int i = 0; i < 6; i++) {
            cache.set(i,i+1);
        }

        System.out.println(cache.get(4));
        System.out.println(cache.get(6));
        System.out.println(cache.get(3));
    }

}
