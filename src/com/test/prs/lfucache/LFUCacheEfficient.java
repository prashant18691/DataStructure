package com.test.prs.lfucache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// O(1) complexity
public class LFUCacheEfficient {
    private Map<Integer,Node> valueMap = new HashMap<>();//holds key-value
    private TreeMap<Integer, DoubleLinkedList> frequencyMap = new TreeMap<>();// holds count-LinkedList<key>
    private Integer MAX_CAPACITY;

    public LFUCacheEfficient(final Integer MAX_CAPACITY) {
        this.MAX_CAPACITY = MAX_CAPACITY;
    }

    public Integer get(int key){
        if (!valueMap.containsKey(key))
            return -1;
        Node node = valueMap.get(key);
        int frequency = node.count;
        node.count++;
        frequencyMap.get(frequency).remove(node);
        if (frequencyMap.get(frequency).size()==0)
            frequencyMap.remove(frequency);
        frequencyMap.computeIfAbsent(frequency+1, k -> new DoubleLinkedList()).add(node);
        return node.value;
    }

    public void set(int key, int value){
        if (!valueMap.containsKey(key)){
            Node node = new Node(key, value);
            if (valueMap.size()==MAX_CAPACITY){
                int lowestCount = frequencyMap.firstKey();
                Node nodeToDelete = frequencyMap.get(lowestCount).getHead();
                frequencyMap.get(lowestCount).remove(nodeToDelete);
                if (frequencyMap.get(lowestCount).size()==0)
                    frequencyMap.remove(lowestCount);
//                countMap.remove(nodeToDelete.key);
                valueMap.remove(nodeToDelete.key);
            }
            valueMap.put(key,node);
            node.count++;
//            countMap.put(key,1);
            frequencyMap.computeIfAbsent(1, k -> new DoubleLinkedList()).add(node);
        }
    }

}

class Node{
    int key, value, count;
    Node next,prev;

    Node(final int key, final int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkedList{
    int n;
    Node head, tail;

    void add(Node node){
        if (head==null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        n++;
    }

    void remove(Node node){
        if (node.next==null) { // tail
            tail = node.prev;
        }
        else if(node.prev==null){ // head
           head = node.next;
        }
        else{
            node.prev.next = node.next;
        }
        n--;
    }

    Node getHead(){
        return head;
    }

    int size(){
        return n;
    }
}
