package com.test.prs.Queue;

import java.util.Stack;

public class ImplementQueueUsing2Stacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void add(int i){//add costly
        if(s1.size()==0)
            s1.push(i);
        else {
            while (s1.size() > 0)
                s2.push(s1.pop());
            s2.push(i);
            while(s2.size()>0)
                s1.push(s2.pop());
        }
    }
    int remove(){
        int i=-1;
        if(s1.size()>0)
            i=s1.pop();
        return i;
    }

    void addCheap(int i){
        s1.push(i);
    }

    int removeCostly(){
        if(s2.size()==0) {
            while (s1.size() > 0)
                s2.push(s1.pop());
           return s2.pop();
        }
        return s2.pop();
    }

    /**
     * costly remove
     * while(s1.size>0)
     * s2.push(s1.pop())
     *int return = s2.pop();
     * while(s2.size>0)
     *s1.push(s2.pop())
     */

    public static void main(String[] args) {
        ImplementQueueUsing2Stacks t = new ImplementQueueUsing2Stacks();
        t.addCheap(1);
        t.addCheap(2);
        t.addCheap(3);
        System.out.println(t.removeCostly());
        System.out.println(t.removeCostly());
        t.addCheap(4);
        System.out.println(t.removeCostly());
        System.out.println(t.removeCostly());

       /* Stack stack = new Stack();

        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println(stack.search("2"));*/
    }
}
