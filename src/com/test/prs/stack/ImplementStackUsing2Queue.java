package com.test.prs.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsing2Queue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {
        ImplementStackUsing2Queue t = new ImplementStackUsing2Queue();
        t.push(1);
        t.push(2);
        t.push(3);
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
    }

    private int pop() {//cheap pop
       int i=-1;
       if(q1.size()>0)
           i=q1.remove();
       return i;
    }

    private void push(int i) {// push costly
        if(q1.size()==0)
            q1.add(i);
        else{
            while(q1.size()>0)
                q2.add(q1.remove());
            q1.add(i);
            q1.addAll(q2);
            q2.clear();
        }
    }

    //costly pop
    /**
     * pop(){
     *     copy n-1 elements from q1 to q2
     *     int removed = q1.remove()
     *     q1.addAll(q2);
     *     q2.clear();
     *     return removed;
     *
     * }
     *
     */
}
