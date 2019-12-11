package com.test.prs.lrucache;

import java.util.*;

public class LRUCache<T> {

    DoublyLinkedList<T> dq;
    Map<T,Node<T>> map;
    final int capacity;

    public LRUCache(int capacity) {
        dq = new DoublyLinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;

    }

    public T get(T key) {
        if(map.containsKey(key)){
            Node<T> value = map.get(key);
            put(key,value.val);
            return value.val;
        }
        return null;
    }

    public void put(T key, T value) {
        if(!map.containsKey(key)){
            Node<T> newNode = new Node<>();
            newNode.val=value;
            newNode.key=key;
            if(map.size()==capacity){
                T x = dq.removeLast();
                map.remove(x);
            }
            dq.add(newNode);
            map.put(key, newNode);
        }
        else{
            Node<T> node = map.get(key);
            node.val=value;
            dq.remove(node);//O(1)
            dq.add(node);//add at top
        }
    }
}


class DoublyLinkedList<T>{
    Node<T> head;
    Node<T> tail;
    int size;

    void add(Node<T> node){//adds at the head
        node.next = head;
        node.prev = null;
        if (head != null)
            head.prev = node;
        head = node;
        if (tail == null)
            tail = head;
        size++;
    }

    T removeLast(){
        Node<T> last = tail;
        if (last==null)
            throw new NoSuchElementException();
        T val = last.val;
        Node<T> prev = last.prev;
        last.val=null;
        last.prev=null;
        tail = prev;
        if (prev==null){
            head = null;
        }
        else{
            prev.next=null;
        }
        size--;
        return val;
    }

    T removeFirst(){
        Node<T> begin = head;
        if (begin==null)
            throw new NoSuchElementException();
        T val = begin.val;
        Node<T> next = begin.next;
        begin.val = null;
        begin.next = null;
        head = next;
        if (next==null){
            tail=null;
        }
        else{
            next.prev=null;
        }
        size--;
        return val;
    }

    void remove(Node<T> node){
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }


}

class Node<T>{
    Node<T> prev;
    T key;
    T val;
    Node<T> next;

    public Node() {
    }

    public Node(Node<T> prev, T val, Node<T> next) {
        this.prev = prev;
        this.val = val;
        this.next = next;
    }


}
