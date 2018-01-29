package com.test.prs.linkedlist;

public class MergeSort {
    LinkedList head;
    public LinkedList sort(LinkedList n){
        if(n==null || n.getNext()==null)
            return n;
        LinkedList middle = getMiddle(n);
        LinkedList nextToMiddle = middle.getNext();
        middle.setNext(null);
        LinkedList left = sort(n);
        LinkedList right = sort(nextToMiddle);
        return merge(left,right);
    }

    private LinkedList merge(LinkedList a, LinkedList b) {
        LinkedList result = null;
        if(a==null)
            return b;
        if(b==null)
            return a;

        if(a.getData()<b.getData()){
            result = a;
            result.setNext(merge(a.getNext(),b));
        }
        else{
            result = b;
            result.setNext(merge(a,b.getNext()));
        }
        return result;
    }

    private LinkedList getMiddle(LinkedList n) {
        if(n==null)
            return n;
        LinkedList fast = n.getNext();
        LinkedList slow = n;
        while(fast!=null){
            fast = fast.getNext();
            if(fast!=null){
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }
        return slow;
    }

    public void push(int x){
        LinkedList n = new LinkedList(x);
        n.setNext(head);
        head = n;
    }

    public static void main(String[] args) {
        MergeSort li = new MergeSort();
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);

        li.printList(li.head);
        li.sort(li.head);
        li.printList(li.head);
    }

    private void printList(LinkedList n) {
        System.out.println();
        while(n!=null){
            System.out.print(n.getData()+" --> ");
            n=n.getNext();
        }
    }
}
