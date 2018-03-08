package com.test.prs.hashtable;

import java.util.Arrays;

public class Hashtable<K,V> {
    Hashnode<K,V>[] bucketArray;
    int capacity;
    int size;
    public Hashtable(){
        this.size=0;
        this.capacity=10;
        this.bucketArray=new Hashnode[capacity];
        for (int i = 0; i < capacity; i++) {
            bucketArray[i]=null;
        }
    }

    public int size(){
        return this.size;
    }

    public int getBucketIndex(K key){
        int hashcode = key.hashCode();
        return hashcode%capacity;
    }

    public V get(K key){
        int index = getBucketIndex(key);
        Hashnode head=bucketArray[index];
        while(head!=null){
            if(head.key.equals(key)){
                return (V)head.value;
            }
            head=head.next;
        }
        return null;
    }

    public void add(K key, V value){
        int index = getBucketIndex(key);
        Hashnode head=bucketArray[index];
        while(head!=null){
            if(head.key.equals(key)){
                head.value=value;
                return;
            }
            head=head.next;
        }
        ensureCapacity();
        size++;
        Hashnode newNode = new Hashnode(key,value);
        newNode.next=head;
        bucketArray[index]=newNode;
    }

    private void ensureCapacity() {
        if (size/capacity>=0.7){
            capacity = capacity << 1;
            bucketArray = Arrays.copyOf(bucketArray, capacity);
        }
    }

    public V remove(K key){
        int index = getBucketIndex(key);
        Hashnode head=bucketArray[index];
        Hashnode prev = null;
        while(head!=null){
            if(head.key.equals(key))
                break;
            prev = head;
            head=head.next;
        }
        if(head==null) return null;
        size--;
        if (prev!=null)
            prev.next=head.next;
        else
            bucketArray[index]=head.next;
        return (V)head.value;

    }
    public static void main(String[] args){
        Hashtable<String,Integer> table = new Hashtable<>();
        table.add("one",1);
        table.add("two",2);
        System.out.println(table.size());
        System.out.println(table.get("one"));
        table.remove("one");
        System.out.println(table.size());
        System.out.println(table.get("one"));

    }
}
class Hashnode<K,V> {
    final K key;
    V value;
    Hashnode next;
    public Hashnode(K key, V value){
        this.key=key;
        this.value=value;
    }

}