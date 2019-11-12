package com.test.prs.linkedlist;

import java.util.Stack;


public class TestPalindrome {
    LinkedList head;
    public boolean method1(){//O(n) complexity; space
        boolean isPalindrome = false;
        Stack<Integer> stack = new Stack<>();
        LinkedList node = head;
        while (node!=null) {
            stack.push(node.getData());
            node = node.getNext();
        }
        node = head;
        while (node!=null && node.getData()==stack.peek()){
            stack.pop();
            node=node.getNext();
        }
        if (stack.size()==0)
            isPalindrome = true;
        return isPalindrome;
    }

    public boolean method2(){ //O(n) time; O(1) space
        boolean isPalindrome = false;
        LinkedList midNode = null; // to handle odd case
        LinkedList fast_ptr = head;
        LinkedList slow_ptr = head;
        LinkedList previous_to_slow_ptr = null;

        while (fast_ptr!=null && fast_ptr.getNext()!=null){
            fast_ptr = fast_ptr.getNext().getNext();
            previous_to_slow_ptr = slow_ptr;
            slow_ptr = slow_ptr.getNext();
        }

        if (fast_ptr!=null) {//odd number of nodes
            midNode = slow_ptr;
            slow_ptr = slow_ptr.getNext();
        }
        previous_to_slow_ptr.setNext(null);// to terminate 1st half while comparing
        LinkedList secondHalf = slow_ptr;
        LinkedList reversedSecondHalf = reverse(secondHalf);
        isPalindrome = compareLL(head, reversedSecondHalf);
        secondHalf = reverse(reversedSecondHalf);
        if (midNode!=null){
            previous_to_slow_ptr.setNext(midNode);
            midNode.setNext(secondHalf);
        }
        else{
            previous_to_slow_ptr.setNext(secondHalf);
        }
        return isPalindrome;
    }

    private boolean compareLL(LinkedList head1, LinkedList head2) {
        LinkedList node1 = head1;
        LinkedList node2 = head2;
        while (node1!=null && node2!=null){
            if (node1.getData()==node2.getData())
            {
                node1 = node1.getNext();
                node2 = node2.getNext();
            }
            else
                return false;
        }
        if (node1==null && node2==null)
            return true;

        return false;
    }

    private LinkedList reverse( LinkedList node) {
        LinkedList curr = node;
        LinkedList prev = null;
        LinkedList next = null;
        while(curr!=null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

    void add(int data){
        LinkedList newNode = new LinkedList(data);
        if (head==null)
            head = newNode;
        else{
            newNode.setNext(head);
            head = newNode;
        }
    }

    public static void main(String[] args) {
        TestPalindrome testPalindrome = new TestPalindrome();
        testPalindrome.add(1);
        testPalindrome.add(2);
        testPalindrome.add(2);
        testPalindrome.add(1);
        if (testPalindrome.method2()) {
            System.out.println("A Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        testPalindrome.printLL();
    }

    private  void printLL() {
        LinkedList node = head;
        while (node!=null){
            System.out.print(node.getData()+" --> ");
            node = node.getNext();
        }
    }
}
