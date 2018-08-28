package com.test.prs.linkedlist;

public class ReverseAlternateKNodes {
    Node head;
    Node prev = null;

    boolean add(int data){
        return false;
    }

    void solution(){

    }

    Node reverseNodes(Node node){
        if (node==null)
            return null;
        Node curr = node;
        int count = 0;
        while(curr!=null && count==3){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        return prev;
    }
}

class Node{
    int data;
    Node next;

    Node(final int data) {
        this.data = data;
    }
}
