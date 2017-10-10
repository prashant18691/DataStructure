package com.test.prs.heap;

public class TestHeapify {

    public void doHeapify(int[] input){
        if(input==null)
            return;
        int n = input.length;

        for(int i=(n-1)/2;i>=0;i--)
            maxHeapify(input,i,n);

        //sorting
        for(int i=0;i<n;i++){
            int temp=input[0];
            input[0]=input[n-1-i];
            input[n-1-i]=temp;
            maxHeapify(input,0,n-1-i);
        }
    }
    //min heap
    void findKthSmallest(int[] input, int k){
        if(input==null)
            return;
        int n = input.length;

        for(int i=(n-1)/2;i>=0;i--)
            minHeapify(input,i,n);

        for(int i=0;i<k;i++) {
            int smallest = extractMin(input);
            if (i == k-1)
                System.out.println(smallest);
        }
    }
    //min heap && findSmallest
    private int extractMin(int[] input) {
        int length = input.length;
        if(length==0)
            return Integer.MAX_VALUE;

        int root = input[0];

        if(length>1){
            input[0]=input[length-1];
            minHeapify(input,0,length);
        }
        length--;

        return root;
    }
    //max heap
    void findKthSmallest1(int[] input, int k){
        if(input==null)
            return;
        int n = input.length;

        for(int i=(k-1)/2;i>=0;i--)
            maxHeapify(input,i,k);

//        System.out.println(extract(input, k, n));
        for(int j=0;j<k;j++){
            System.out.print(input[j]+" ");
        }
    }
    //max heap && findSmallest
    private int extract(int[] input, int k, int n) {
        for(int i=k;i<n;i++){
            if(input[i]<input[0]){
                input[0]=input[i];
                maxHeapify(input,0,k);
            }
        }

        return input[0];
    }

    private void maxHeapify(int[] input, int i, int n) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && input[left]>input[largest])
            largest = left;
        if(right<n && input[right]>input[largest])
            largest=right;

        if(largest!=i){
            int a = input[i];
            input[i] = input[largest];
            input[largest] = a;
            maxHeapify(input,largest,n);
        }
    }

    private void minHeapify(int[] input, int i, int n) {
        int smallest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && input[left]<input[smallest])
            smallest = left;
        if(right<n && input[right]<input[smallest])
            smallest=right;

        if(smallest!=i){
            int a = input[i];
            input[i] = input[smallest];
            input[smallest] = a;
            minHeapify(input,smallest,n);
        }
    }

    public static void main(String[] args){
        TestHeapify test = new TestHeapify();
        int[] arr = {12, 3, 5, 7, 19};
        test.findKthSmallest1(arr,4);
        System.out.println("Max Heap");
        for(int i : arr)
            System.out.print(i+" ");
    }

}
