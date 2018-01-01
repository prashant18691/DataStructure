package com.test.prs.map;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyMap<K,V> {

    private int size;
    private int capacity = 16;
    private MapEntry<K,V>[] entry = new MapEntry[capacity];

    public V get(K key){
        for(int i=0;i<size;i++){
            if(entry[i]!=null){
                if(entry[i].getKey().equals(key)){
                    return entry[i].getValue();
                }
            }
        }
        return null;
    }

    public void put(K key, V value){
        for(int i=0;i<size;i++){
            if(entry[i]!=null){
                if(entry[i].getKey().equals(key)){
                    entry[i].setValue(value);
                    return;
                }
            }
        }
        ensureCapacity();
        entry[size++] = new MapEntry<>(key,value);
    }

    private void ensureCapacity() {
        if(size==capacity){
            capacity = capacity << 1;
            entry = Arrays.copyOf(entry, capacity);
        }
    }

    public int size(){
        return size;
    }

    public void remove(K key){
        for(int i=0;i<size;i++){
            if(entry[i]!=null){
                if(entry[i].getKey().equals(key)){
                    entry[i].setValue(null);
                    size--;
                    condenseArray(i);
                    return;
                }
            }
        }
    }

    private void condenseArray(int start) {
        for(int i=start; i<size; i++){
            entry[i] = entry[i+1];
        }
    }

    public Set<K> keySet(){
        Set<K> set = new HashSet<K>();
        for(int i=0;i<size;i++){
            set.add(entry[i].getKey());
        }
        return set;
    }

}
