package com.test.prs.linkedlist;

public class SplitDoublyLL {
    static DoubleLinkedList head;
    static DoubleLinkedList tail;
    public static void add(int data){
        // DoubleLinkedList current=head;
        if(head==null){
            head=new DoubleLinkedList(null,data,null);
            tail=head;
        }
        else{
            tail.next=new DoubleLinkedList(tail,data,null);
            tail=tail.next;
        }
    }
    public static void splitLinkedList(DoubleLinkedList head){
        DoubleLinkedList evenStart = null;
        DoubleLinkedList evenEnd = null;
        DoubleLinkedList oddStart = null;
        DoubleLinkedList oddEnd = null;
        DoubleLinkedList current = head;
        while(current!=null){
            int element = current.data;
            if(element%2==0){
                if(evenStart==null){
                    evenStart=current;
                    evenStart.prev=null;
                    evenEnd=evenStart;
                }
                else{
                    evenEnd.next=current;
                    evenEnd.next.prev=evenEnd;
                    evenEnd=evenEnd.next;
                }
            }
            else{
                if(oddStart==null){
                    oddStart=current;
                    oddStart.prev=null;
                    oddEnd=oddStart;
                }
                else{
                    oddEnd.next=current;
                    oddEnd.next.prev=oddEnd;
                    oddEnd=oddEnd.next;
                }
            }
            current=current.next;
        }
        oddEnd.next=null;
        System.out.println("prev  "+"curr  "+"next");
        printLL(evenStart);
        printLL(oddStart);
    }

    public static void printLL(DoubleLinkedList n){
        while(n!=null){
            Integer prev=n.prev!=null?n.prev.data:null;
            Integer next=n.next!=null?n.next.data:null;
            System.out.println(prev+"     "+n.data+"     "+next);
            n=n.next;
        }

    }

    public static void main(String[] args){
        add(1);
        add(2);
        add(3);
        add(4);
        // printLL(head);
        splitLinkedList(head);
    }
}

class DoubleLinkedList{
    int data;

    DoubleLinkedList prev;
    DoubleLinkedList next;

    public DoubleLinkedList(DoubleLinkedList prev,int data,DoubleLinkedList next){
        this.prev=prev;
        this.data=data;
        this.next=next;
    }
}
