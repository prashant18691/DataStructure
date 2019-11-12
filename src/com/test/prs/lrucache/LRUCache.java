package com.test.prs.lrucache;

import java.util.*;

public class LRUCache<T> {

    Deque<T> dq;
    Map<Integer,T> map;
    int capacity;

    public LRUCache(int capacity) {
        dq = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;

    }

    public T get(int key) {
        if(map.containsKey(key)){
            T value = map.get(key);
            put(key,value);
            return value;
        }
        return null;
    }

    public void put(int key, T value) {
        if(!map.containsKey(key)){
            if(map.size()==capacity){
                T x = dq.removeFirst();
                map.remove(x);
            }
        }
        else{
            Iterator<T> it = dq.iterator();
            int index = 0;
            while(it.hasNext()){
                if(it.next()==value){
                    break;
                }
                index++;
            }
            if(index!=-1)
                dq.remove(key);
        }
        map.put(key,value);
        dq.add(value);
    }
}
