package com.test.prs.lfucache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;


public class LFUCacheEfficient {
    private Map<Integer,Integer> valueMap = new HashMap<>();//holds key-value
    private Map<Integer,Integer> countMap = new HashMap<>();// holds key-count
    private TreeMap<Integer, LinkedList<Integer>> frequencyMap = new TreeMap<>();// holds count-LinkedList<key>
    private Integer MAX_CAPACITY;

    public LFUCacheEfficient(final Integer MAX_CAPACITY) {
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    public Integer get(int key){
        if (!valueMap.containsKey(key))
            return -1;
        int frequency = countMap.get(key);
        countMap.put(key,frequency+1);
        frequencyMap.get(frequency).remove(new Integer(key));
        if (frequencyMap.get(frequency).size()==0)
            frequencyMap.remove(frequency);
        frequencyMap.computeIfAbsent(frequency+1, k -> new LinkedList<>()).add(key);
        return valueMap.get(key);
    }

    public void set(int key, int value){
        if (!valueMap.containsKey(key)){
            if (valueMap.size()==MAX_CAPACITY){
                int lowestCount = frequencyMap.firstKey();
                int keyToBeEvicted = frequencyMap.get(lowestCount).removeFirst();
                if (frequencyMap.get(lowestCount).size()==0)
                    frequencyMap.remove(lowestCount);
                countMap.remove(keyToBeEvicted);
                valueMap.remove(keyToBeEvicted);
            }
            valueMap.put(key,value);
            countMap.put(key,1);
            frequencyMap.computeIfAbsent(1, k -> new LinkedList<>()).add(key);
        }
    }
}
