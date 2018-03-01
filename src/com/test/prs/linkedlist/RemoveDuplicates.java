package com.test.prs.linkedlist;

public class RemoveDuplicates {
    LinkedList head;
    public static LinkedList removeDuplicates(LinkedList head) {
        int count = 0;
        LinkedList temp = head;
        while(temp!=null && temp.getNext()!=null){
            if(temp.getData()==temp.getNext().getData())
                temp.setNext(temp.getNext().getNext());
            else
                temp = temp.getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicates f = new RemoveDuplicates();
        f.head = new LinkedList(1);
        f.head.setNext(new LinkedList(2));
        f.head.getNext().setNext(new LinkedList(2));
        f.head.getNext().getNext().setNext(new LinkedList(3));
        f.head.getNext().getNext().getNext().setNext(new LinkedList(3));
        f.head.getNext().getNext().getNext().getNext().setNext(new LinkedList(4));
        printLL(f.head);
        removeDuplicates(f.head);
        System.out.println();
        printLL(f.head);
    }

    private static void printLL(LinkedList head) {
        while (head!=null) {
            System.out.print(head.getData() + " -> ");
            head=head.getNext();
        }
        System.out.print("null");
    }
}
