package com.test.prs.linkedlist;

public class MergeSortedLinkedList {

    public static LinkedList mergeLL(LinkedList n1, LinkedList n2){
        if (n1==null) return n2;
        if (n2==null) return n1;
        if (n1.getData()<=n2.getData()) {
            n1.setNext(mergeLL(n1.getNext(), n2));
            return n1;
        }
        else {
            n2.setNext(mergeLL(n1, n2.getNext()));
            return n2;
        }

    }

    static void addNode(LinkedList head, int data){
           while (head.getNext()!=null)
               head = head.getNext();
           head.setNext(new LinkedList(data));
    }

    public static void main(String[] args) {
        LinkedList h1 = new LinkedList(1);
        addNode(h1,2);
        addNode(h1,3);
        addNode(h1,4);
//        printLL(h1);
        LinkedList h2 = new LinkedList(5);
        addNode(h2,6);
        addNode(h2,7);
        addNode(h2,8);
//        printLL(h2);
        LinkedList mergedHead = mergeLL(h1,h2);
        printLL(mergedHead);
    }

    private static void printLL(LinkedList h) {
        while (h!=null){
            System.out.print(h.getData()+" --> ");
            h = h.getNext();
        }
        System.out.println();
    }
}
