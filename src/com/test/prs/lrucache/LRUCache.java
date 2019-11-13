package com.test.prs.lrucache;

import java.util.*;

public class LRUCache<T> {

    DoublyLinkedList<T> dq;
    Map<T,T> map;
    final int capacity;

    public LRUCache(int capacity) {
        dq = new DoublyLinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;

    }

    public T get(T key) {
        if(map.containsKey(key)){
            T value = map.get(key);
            put(key,value);
            return value;
        }
        return null;
    }

    public void put(T key, T value) {
        if(!map.containsKey(key)){
            if(map.size()==capacity){
                T x = dq.removeLast();
                map.remove(x);
            }
        }
        else{
            /*Iterator<T> it = dq.iterator();
            int index = 0;
            while(it.hasNext()){
                if(it.next()==value){
                    break;
                }
                index++;
            }
            if(index!=-1)*/
                dq.remove(key);
        }
        map.put(key,value);
        dq.add(key);
    }
}


class DoublyLinkedList<T>{
    Node<T> head;
    Node<T> tail;
    int size;

    void add(T t){//adds at the head
        Node<T> begin = head;
        Node<T> newNode = new Node<>(null,t,begin);
        head = newNode;
        if (begin==null){
            tail = newNode;
        }
        else{
            begin.prev = newNode;
        }
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

    boolean remove(T val){
        for (Node<T> i = head;i!=null;i=i.next){
            if (val.equals(i.val)){
                Node<T> prev = i.prev;
                Node<T> next = i.next;
                if (prev==null){//head is being removed
                    head=next;
                }
                else{
                    prev.next=next;
                    i.prev = null;
                }
                if (next==null){
                    tail = prev;
                }
                else{
                    next.prev = prev;
                    i.next = null;
                }
                i.val = null;
                return true;
            }
        }
        return false;
    }


}

class Node<T>{
    Node<T> prev;
    T val;
    Node<T> next;

    public Node(Node<T> prev, T val, Node<T> next) {
        this.prev = prev;
        this.val = val;
        this.next = next;
    }
}
