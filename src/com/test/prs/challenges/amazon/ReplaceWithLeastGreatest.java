package com.test.prs.challenges.amazon;

public class ReplaceWithLeastGreatest {
    LinkedList replace(LinkedList head){
        LinkedList newHead = null;
        while(head!=null){
            if(newHead==null)
                newHead = new LinkedList(head.num);
        }
        return newHead;
    }
}
