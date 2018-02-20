package com.test.prs.ArrayList;

import java.util.Arrays;

public class MyArrayList {
    private int size;
    private  int CAPACIY = 10;
    private int[] array;

    public MyArrayList() {
        this.array = new int[CAPACIY];
    }

    public void add(int a){
        ensureCapacity();
        array[size++] = a;
    }

    public int get(int i){
        isEmpty();
        checkBound(i);
        return array[i];
    }

    public int remove(int i){
        isEmpty();
        checkBound(i);
        int a = array[i];
        size--;
        condenseArray(i);
        return a;
    }

    private void checkBound(int i) {
        if (i>=size || i<0)
            throw new IndexOutOfBoundsException("Index "+i+" is out of bound");
    }

    private void condenseArray(int start) {
        for (int i = start; i < size; i++) {
            array[i] = array[i+1];
        }
    }

    private void isEmpty() {
        if (size==0)
        throw new IllegalArgumentException("ArrayList is Empty");
    }

    private void ensureCapacity() {
        if (size==CAPACIY)
        {
            CAPACIY = CAPACIY<<1;
            array = Arrays.copyOf(array,CAPACIY);
        }
    }

    public int size(){
        return size;
    }

    public MyIterator iterator(){
        return new MyIteratorImpl(array);
    }
    private class MyIteratorImpl implements MyIterator{
        private int position;
        private int[] array;

        public MyIteratorImpl(int[] array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            if (position<array.length)
                return true;
            return false;
        }

        @Override
        public int next() {
            int a = array[position];
            position++;
            return a;
        }
    }
}
