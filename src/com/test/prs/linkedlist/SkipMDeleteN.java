package com.test.prs.linkedlist;

public class SkipMDeleteN {
    public static LinkedList skipMDeleteN(LinkedList head,int m,int n){
        LinkedList curr = head;
        while (curr!=null){
            for (int i = 1; i < m && curr!=null; i++) {
                curr = curr.getNext();
            }
            if (curr==null)
                return head;
            LinkedList t = curr.getNext();
            for (int i = 0; i < n && t!=null; i++) {
                t = t.getNext();
            }
            curr.setNext(t);
            curr = t;
        }
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
        printLL(h1);
        LinkedList head = skipMDeleteN(h1, 1, 1);
        printLL(head);
    }

}
