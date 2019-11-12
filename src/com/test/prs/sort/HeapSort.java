package com.test.prs.sort;

import java.util.Arrays;


public class HeapSort {
    public int[] sort(int[] arr){
        if (arr==null || arr.length==0) return null;
        if (arr.length==1) return arr;
        int n = arr.length;
        for (int i = (n-1)/2; i >=0 ; i--) {
            maxHeapify(arr, i, n);
        }
        for (int i = n-1; i >=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(arr,0,i);
        }
        return arr;
    }

    private void maxHeapify(int[] arr,  int i,  int n) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if (left<n && arr[left]>arr[largest])
            largest = left;
        if (right<n && arr[right]>arr[largest])
            largest = right;
        if (largest!=i){
            swap(arr, i, largest);
            maxHeapify(arr, largest, n);
        }
    }

    private void swap( int[] arr,  int i,  int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {5,3,5,7,2,8};
        System.out.println(Arrays.toString(heapSort.sort(arr)));
    }
}
