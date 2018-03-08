package com.test.prs.linkedlist;

public class RotateLinkedList {
    public static LinkedList rotateLinkedList(LinkedList head, int k){// (k+1)th becomes head node
        LinkedList curr = head;
        int count = 1;
        while (curr!=null && count<k) {
            curr = curr.getNext();
            count++;
        }
        if (curr==null)
            return head;
        LinkedList kthNode = curr;
        while (curr.getNext()!=null)
            curr=curr.getNext();
        curr.setNext(head);//last points to previous head
        head = kthNode.getNext();
        kthNode.setNext(null);
        return head;
    }

    static void addNode(LinkedList head, int data){
        while (head.getNext()!=null)
            head = head.getNext();
        head.setNext(new LinkedList(data));
    }

    private static void printLL(LinkedList h) {
        while (h!=null){
            System.out.print(h.getData()+" --> ");
            h = h.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList h1 = new LinkedList(1);
        addNode(h1,2);
        addNode(h1,3);
        addNode(h1,4);
        addNode(h1,5);
        addNode(h1,6);
        addNode(h1,7);
        addNode(h1,8);
        addNode(h1,9);
        printLL(h1);
        LinkedList head = rotateLinkedList(h1, 4);
        printLL(head);
    }
}
