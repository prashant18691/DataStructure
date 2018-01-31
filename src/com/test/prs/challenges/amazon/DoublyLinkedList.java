package com.test.prs.challenges.amazon;

public class DoublyLinkedList {
    char c;
    DoublyLinkedList prev,next;

    public DoublyLinkedList(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return String.valueOf(c);
    }
}
