package com.test.prs.challenges.amazon;

public class PairLinkedList {
     DoublyLinkedList head;

    public static DoublyLinkedList pairLL(DoublyLinkedList head1, DoublyLinkedList head2){ // merge with longer ll to merge all nodes
        int node_count1 = countNodes(head1);
        int node_count2 = countNodes(head2);
        if(node_count1>node_count2) {
            solve(head1,head2);
            return head1;
        }
            solve(head2,head1);
            return head2;
    }

    private static void solve(DoublyLinkedList largeHead, DoublyLinkedList shortHead){
        DoublyLinkedList node1 = largeHead;
        DoublyLinkedList node2 = shortHead;

        while(node1!=null && node2!=null){
            DoublyLinkedList temp = node1.next;
            node1.next = node2;
            node2.prev = node1;
            shortHead = shortHead.next;
            node2.next = temp;
            temp.prev = node2;
            node1=node1.next.next;
            node2 = shortHead;
        }
    }

    private static int countNodes(DoublyLinkedList node) {
        if (node == null) return 0;
        return 1 + countNodes(node.next);
    }

    public static void main(String[] args) {
        PairLinkedList p = new PairLinkedList();
        p.head = new DoublyLinkedList('H');
        p.head.prev=null;

        DoublyLinkedList h1 = new DoublyLinkedList('e');
        p.head.next=h1;
        h1.prev = p.head;

        DoublyLinkedList h2 = new DoublyLinkedList('L');
        h1.next=h2;
        h2.prev = h1;

        DoublyLinkedList h3 = new DoublyLinkedList('L');
        h2.next=h3;
        h3.prev = h2;

        DoublyLinkedList h4 = new DoublyLinkedList('o');
        h3.next=h4;
        h4.prev = h3;
        h4.next = null;

        PairLinkedList q = new PairLinkedList();
        q.head = new DoublyLinkedList('1');
        q.head.prev=null;

        DoublyLinkedList s1 = new DoublyLinkedList('2');
        q.head.next=s1;
        s1.prev = q.head;

        DoublyLinkedList s2 = new DoublyLinkedList('3');
        s1.next=s2;
        s2.prev = s1;
        s2.next=null;
        DoublyLinkedList mergedHead = pairLL(p.head,q.head);
        printLL(mergedHead);

    }

    private static void printLL(DoublyLinkedList node) {
        System.out.println("Previous   Current   Next");
        while(node!=null){
            System.out.println(node.prev+"          "+node.c+"         "+node.next);
            node = node.next;
        }
    }
}
