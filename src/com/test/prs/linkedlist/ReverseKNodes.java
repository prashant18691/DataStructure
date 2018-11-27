package com.test.prs.linkedlist;

public class ReverseKNodes {
    LinkedList head;
    LinkedList prev;


    public LinkedList reverse(LinkedList node, int k){
        LinkedList curr = node;
        LinkedList prev = null;
        int count = 0;
        while(curr!=null && count<k){
            LinkedList next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            count++;
        }
        if (curr!=null)
            node.setNext(reverse(curr, k));

        return prev;
    }

    LinkedList reverseNodes(LinkedList node){
        if (node==null)
            return null;
        LinkedList curr = node;
        while(curr!=null){
            LinkedList next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void addNode(LinkedList head, int data){
        while (head.getNext()!=null)
            head = head.getNext();
        head.setNext(new LinkedList(data));
    }

    public static void main(String[] args) {
        ReverseKNodes reverseKNodes = new ReverseKNodes();
        reverseKNodes.head = new LinkedList(1);
        LinkedList h1 = reverseKNodes.head;
        addNode(h1,2);
        addNode(h1,3);
        addNode(h1,4);
        addNode(h1,5);/*
        addNode(h1,6);
        addNode(h1,7);
        addNode(h1,8);*/
        printLL(h1);
        LinkedList rev = reverseKNodes.reverse(h1,3);
        printLL(rev);
    }

    private static void printLL(LinkedList h) {
        while (h!=null){
            System.out.print(h.getData()+" --> ");
            h = h.getNext();
        }
        System.out.println();
    }
}


