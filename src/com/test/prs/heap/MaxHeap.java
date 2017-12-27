package com.test.prs.heap;

public class MaxHeap extends Heap {
    @Override
    public void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)){
            int largest = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index)>leftChild(index))
                largest = getRightChildIndex(index);
            if(items[index]>items[largest])
                break;
            else
                swap(index,largest);
            index = largest;
        }
    }

    @Override
    public void heapifyUp() {
        int index = size-1;
        while(hasParent(index) && parent(index)<items[index]){
            swap(getParentindex(index),index);
            index = getParentindex(index);
        }
    }
}
