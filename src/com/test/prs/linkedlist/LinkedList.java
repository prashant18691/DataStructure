package com.test.prs.linkedlist;

public class LinkedList {
    private int data;
    private LinkedList next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public LinkedList(int data) {
        this.data = data;
    }
}
