package com.test.prs.linkedlist;

public class MergeLinkedList {
    LinkedList head;

    void mergeList(LinkedList h1, LinkedList h2){
        int count_h1 = countNodes(h1);
        int count_h2 = countNodes(h2);
        LinkedList bigLL = merge(h1, h2);
        if(count_h1<count_h2){
            while (h1.getNext()!=null)
                h1 = h1.getNext();
            while (bigLL!=null){
                h1.setNext(bigLL);
                h1 = h1.getNext();
                bigLL = bigLL.getNext();
            }
        }
    }

    private LinkedList merge(LinkedList h1, LinkedList h2) {
        LinkedList n1 = h1;
        LinkedList n2 = h2;
        while(n1!=null && n2!=null){
            LinkedList temp = n1.getNext();
            n1.setNext(n2);
            h2 = n2.getNext();
            n2.setNext(temp);
            n1 = n1.getNext().getNext();
            n2 = h2;
        }
        return n2;
    }

    private int countNodes(LinkedList n){
        if(n==null) return 0;
        return 1 + countNodes(n.getNext());
    }

    public void push(int x){
        LinkedList n = new LinkedList(x);
        n.setNext(head);
        head = n;
    }

    public static void main(String[] args) {
        MergeLinkedList l = new MergeLinkedList();
        l.push(3);
        l.push(2);
        l.push(1);

//        l.printList(l.head);
        MergeLinkedList l1 = new MergeLinkedList();
        l1.push(8);
        l1.push(7);
        l1.push(6);
        l1.push(5);
        l1.push(4);
//        System.out.println();
//        l.printList(l1.head);
        System.out.println();
        System.out.println(" After merging");
        l.mergeList(l.head,l1.head);
//        l.printList(l.head);
//        System.out.println();
        l.printList(l.head);

    }

    private void printList(LinkedList n) {
        while(n!=null){
            System.out.print(n.getData()+" --> ");
            n = n.getNext();
        }
    }
}
