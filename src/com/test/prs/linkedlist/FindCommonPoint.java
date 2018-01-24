package com.test.prs.linkedlist;

public class FindCommonPoint {
    LinkedList head1,head2;

    int findCommonPoint(LinkedList h1, LinkedList h2){
        int h1_nodeCount = countNode(h1);
        int h2_nodeCount = countNode(h2);
        int diff = h1_nodeCount-h2_nodeCount;
        if(diff<0)
            h2 = levelNodes(h2, diff);
        else
            h1 = levelNodes(h1,diff);
        while(h1!=null && h2!=null){
            if(h1.getData()==h2.getData())
                return h1.getData();
            h1 = h1.getNext();
            h2 = h2.getNext();
        }
        return -1;
    }

    private LinkedList levelNodes(LinkedList n, int diff) {
        int i=0;
        while (i<Math.abs(diff)){
           n = n.getNext();
            i++;
        }
        return n;
    }

    private int countNode(LinkedList h1) {
        if(h1!=null){
            return 1+countNode(h1.getNext());
        }
        return 0;
    }

    public static void main(String[] args) {
        FindCommonPoint f = new FindCommonPoint();
        f.head1 = new LinkedList(1);
        f.head1.setNext(new LinkedList(2));
        f.head1.getNext().setNext(new LinkedList(3));
        f.head1.getNext().getNext().setNext(new LinkedList(4));
        f.head1.getNext().getNext().getNext().setNext(new LinkedList(5));
        f.head1.getNext().getNext().getNext().getNext().setNext(new LinkedList(6)); // 1>2>3>4>5>6
                                                                                         //        7>5>6
        f.head2 = new LinkedList(7);
        f.head2.setNext(new LinkedList(5));
        f.head2.getNext().setNext(new LinkedList(6));

        System.out.println(f.findCommonPoint(f.head1,f.head2));
    }
}
