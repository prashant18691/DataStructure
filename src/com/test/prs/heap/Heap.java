package com.test.prs.heap;

import java.util.Arrays;

public abstract class Heap {

    protected int size;
    protected int capacity;
    protected int[] items;

    public Heap(){
        this.size=0;
        this.capacity=10;
        this.items = new int[capacity];
    }

    public int getLeftChildIndex(int index){
        return 2*index+1;
    }

    public int getRightChildIndex(int index){
        return 2*index+2;
    }

    public int getParentindex(int index){
        return (index-1)/2;
    }

    public boolean hasLeftChild(int index){
        return getLeftChildIndex(index)<size;
    }

    public boolean hasRightChild(int index){
        return getRightChildIndex(index)<size;
    }

    public boolean hasParent(int index){
        return getParentindex(index)>=0;
    }

    public int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }

    public int rightChild(int index){
        return items[getRightChildIndex(index)];
    }

    public int parent(int index){
        return items[getParentindex(index)];
    }

    public void swap(int i, int j){
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void ensureCapacity(){
        if(size==capacity){
            capacity = capacity << 1; // double the capacity
            items = Arrays.copyOf(items, capacity);
        }
    }

    public int peek(){
        isEmpty();
        return items[0];
    }

    private void isEmpty() {
        if(size==0)
            throw new IllegalArgumentException("Heap is empty");
    }

    public int poll(){
        isEmpty();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public abstract void heapifyDown();

    public abstract void heapifyUp();

}
