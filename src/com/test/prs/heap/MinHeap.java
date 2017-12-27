package com.test.prs.heap;

public class MinHeap extends Heap {
    @Override
    public void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)){
            int smallest = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index)<leftChild(index))
                smallest = getRightChildIndex(index);
            if(items[index]<items[smallest])
                break;
            else
                swap(index,smallest);
            index = smallest;
        }
    }

    @Override
    public void heapifyUp() {
        int index = size-1;
        while(hasParent(index) && parent(index)>items[index]){
            swap(getParentindex(index),index);
            index = getParentindex(index);
        }
    }
}
