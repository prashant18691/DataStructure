package com.test.prs.linkedListInversion;

public class TestLinkedListInversion {
    LinkedList head;

    public LinkedList inverseList(){
        LinkedList prev = null;
        LinkedList current = head;
        LinkedList next = null;
        while(current!=null){ // 1-->2-->3-->4-->5
                next = current.getNext();
                current.setNext(prev);
                prev = current;
                current = next;
        }
        return prev;
     }

     public void printList(LinkedList curr){
        while(curr!=null) {
            System.out.print(curr.getData() + "-->");
            curr=curr.getNext();
        }
     }

     public static void main(String[] args){
        TestLinkedListInversion test = new TestLinkedListInversion();
        test.head = new LinkedList(1);
        LinkedList node_2 = new LinkedList(2);
        test.head.setNext(node_2);
        LinkedList node_3 = new LinkedList(3);
        node_2.setNext(node_3);
        LinkedList node_4 = new LinkedList(4);
        node_3.setNext(node_4);
        LinkedList node_5 = new LinkedList(5);
        node_4.setNext(node_5);
        test.printList(test.head);
        test.head = test.inverseList();
        System.out.println();
        test.printList(test.head);
     }
}
