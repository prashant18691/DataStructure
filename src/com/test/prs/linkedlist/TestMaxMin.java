package com.test.prs.linkedlist;

public class TestMaxMin {
    LinkedList head;

    boolean push(int data){
        LinkedList newNode = new LinkedList(data);
        if(head==null) {
            head = newNode;
            return true;
        }
        LinkedList current = head;
        while(current.getNext()!=null){
            current=current.getNext();
        }
        current.setNext(newNode);
        return false;
    }

    public static void main(String[] args){
        TestMaxMin test = new TestMaxMin();
        test.push(17);
        test.push(22);
        test.push(13);
        test.push(14);
        test.push(15);
        test.findMaxMin();
    }

    private void findMaxMin() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        LinkedList curr = head;
        while(curr!=null){
            if(curr.getData()<min){
                min=curr.getData();
            }
            if(curr.getData()>max){
                max=curr.getData();
            }
            curr=curr.getNext();
        }
        System.out.println("Min : "+min+" Max : "+max);
    }
}
