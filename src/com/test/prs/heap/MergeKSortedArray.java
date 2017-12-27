package com.test.prs.heap;

import java.util.Arrays;

public class MergeKSortedArray {

    private static class MinHeap{
        int i,j;
        int data;

        public MinHeap(int i, int j, int data) {
            this.i = i;
            this.j = j;
            this.data = data;
        }

        @Override
        public String toString() {
            return i+" : "+j+" : "+data;
        }
    }

    int[] mergeArray(int[][] in, int k){
        if(in==null)
            return null;
        int n = in[0].length;
        int[] output = new int[n*k];
        MinHeap[] minHeapArr = new MinHeap[k];
        for(int i=0;i<k;i++)
            minHeapArr[i] = new MinHeap(i,1,in[i][0]);
        minHeapify(minHeapArr,k);

        for(int i=0;i<n*k;i++){
            MinHeap root = minHeapArr[0];
            output[i] = root.data;
            if(root.j<n){
                int data = in[root.i][root.j];
                root.data=data;
                root.j+=1;
            }
            else
                root.data = Integer.MAX_VALUE;
            minHeapArr[0] = root;
            minHeapify(minHeapArr,k);
        }
        return output;
    }

    private void minHeapify(MinHeap[] minHeapArr, int k) {
        for(int i=(k-1)/2;i>=0;i--){
            heapify(minHeapArr,i,k);
        }
    }

    private void heapify(MinHeap[] minHeapArr, int i, int k) {
        if(minHeapArr==null)
            return;
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<k && minHeapArr[left].data<minHeapArr[smallest].data)
            smallest = left;
        if(right<k && minHeapArr[right].data<minHeapArr[smallest].data)
            smallest = right;
        if(smallest!=i){
            swap(minHeapArr,smallest,i);
            heapify(minHeapArr,smallest,k);
        }
    }

    private void swap(MinHeap[] minHeapArr, int smallest, int i) {
        MinHeap temp = minHeapArr[smallest];
        minHeapArr[smallest] = minHeapArr[i];
        minHeapArr[i] = temp;
    }

    public static void  main(String[] args){
        MergeKSortedArray merge = new MergeKSortedArray();
        int arr[][] =  {{2, 6, 12, 34},
            {1, 9, 20, 1000},
            {23, 34, 90, 2000}};
       int[] output =  merge.mergeArray(arr,arr.length);
       System.out.println(Arrays.toString(output));

    }
}
