package com.test.prs.linkedlist;

public class TestLinkedListLoop {

    LinkedList head;
    public boolean detectLoop(){
        LinkedList fast = head;
        LinkedList slow = head;
        while(fast!=null && slow!=null && fast.getNext()!=null){
            fast=fast.getNext().getNext();
            slow=slow.getNext();
            if(slow.equals(fast))
                return true;
        }
        return false;
    }

    boolean push(int data){
        LinkedList newNode = new LinkedList(data);
        if(head==null) {
            head = newNode;
            return true;
        }
        LinkedList current = head;
        while(current.getNext()!=null){
            current=current.getNext();
        }
        current.setNext(newNode);
        return false;
    }

    public static void main(String[] args){
        TestLinkedListLoop llist = new TestLinkedListLoop();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        llist.head.getNext().getNext().getNext().setNext(llist.head);

        System.out.println(llist.detectLoop());
    }

    private void printList(LinkedList n) {
        while(n!=null){
            System.out.print(n.getData()+" --> ");
            n=n.getNext();
        }
    }
}
