package com.test.prs.lfucache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// O(1) complexity
class LFUCacheEfficient {

    private Map<Integer,Node> valueMap;//holds key-value
    private TreeMap<Integer, DoubleLinkedList> frequencyMap;// holds count-LinkedList<key>
    private Integer MAX_CAPACITY;

    public LFUCacheEfficient(int capacity) {
        valueMap = new HashMap<>();
        frequencyMap = new TreeMap<>();
        this.MAX_CAPACITY = capacity;
    }

    public int get(int key) {
        if (!valueMap.containsKey(key))
            return -1;
        Node node = valueMap.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void updateFrequency(Node node) {
        int frequency = node.count;
        node.count++;
        frequencyMap.get(frequency).remove(node);
        if (frequencyMap.get(frequency).size()==0)
            frequencyMap.remove(frequency);
        frequencyMap.computeIfAbsent(frequency+1, k -> new DoubleLinkedList()).add(node);
    }

    public void put(int key, int value) {
        if(MAX_CAPACITY==0) return;
        if (!valueMap.containsKey(key)){
            Node node = new Node(key, value);
            if (valueMap.size()==MAX_CAPACITY){
                int lowestCount = frequencyMap.firstKey();
                Node nodeToDelete = frequencyMap.get(lowestCount).getHead();
                frequencyMap.get(lowestCount).remove(nodeToDelete);
                if (frequencyMap.get(lowestCount).size()==0)
                    frequencyMap.remove(lowestCount);
                valueMap.remove(nodeToDelete.key);
            }
            valueMap.put(key,node);
            node.count++;
            frequencyMap.computeIfAbsent(1, k -> new DoubleLinkedList()).add(node);
        }
        else{
            Node node = valueMap.get(key);
            updateFrequency(node);
            node.value = value;
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
        node.prev = tail;
        if (tail==null){
            tail = node;
            head = node;
        }
        else{
            tail.next = node;
            tail = node;
        }
        n++;
    }

    void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        if (next!=null &&  prev!=null){
            prev.next = next;
            next.prev = prev;
            node.prev=null;
            node.next=null;
        }
        else if (next!=null){//head
            next.prev=null;
            node.next=null;
            head = next;
        }
        else if(prev!=null){//tail
            prev.next=null;
            node.prev=null;
            tail=prev;
        }
        else{
            head=null;
            tail=null;
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

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
