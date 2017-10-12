package com.test.prs.linkedlist;

public class TestLinkedListLoop {

    LinkedList head;
    public boolean detectLoop(){
        LinkedList node1 = head;
        LinkedList node2 = head;
        while(node1!=null){
            node1=node1.getNext();
            if(node1!=null && node1.getNext()!=null){
                node1=node1.getNext();
                node2 = node2.getNext();
            }
        }
        System.out.println(node2.getData());
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
        TestLinkedListLoop test = new TestLinkedListLoop();
        test.push(17);
        test.push(22);
        test.push(12);
        test.push(13);
        test.push(14);
        test.push(15);
        test.detectLoop();
    }
}
