package com.test.prs.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingSingleQueue {
    Queue<Integer> q = new LinkedList<>();
    void push(int i){
        int size = q.size();
        q.add(i);
        for(int a=0;a<size;a++){
            int j = q.remove();
            q.add(j);
        }
    }

    int pop(){
        int i=-1;
        if(q.size()>0)
            i=q.remove();
        return i;
    }

    public static void main(String[] args) {
        ImplementStackUsingSingleQueue t = new ImplementStackUsingSingleQueue();
        t.push(1);
        t.push(2);
        t.push(3);
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
    }
}
