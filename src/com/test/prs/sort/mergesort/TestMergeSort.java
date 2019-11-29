package com.test.prs.sort.mergesort;

import java.util.Arrays;
import java.util.Random;

public class TestMergeSort {
   static  int[] tempArray;
    public static void sort(int[] in, int l, int h){
        if(l<h){
            int m = (l+h)/2;
            sort(in,l,m);
            sort(in,m+1,h);
            merge(in,l,m,h);
        }
    }

    private static void merge(int[] in, int l, int m, int h) {
        for(int i=l;i<=h;i++)
            tempArray[i]=in[i];
        int i = l;
        int j = m+1;
        int k = l; // index for sorted array
        while(i<=m && j<=h){
            if(tempArray[i]<tempArray[j]){
                in[k]= tempArray[i];
                i++;
            }
            else{
                in[k]= tempArray[j];
                j++;
            }
            k++;
        }
        while(i<=m){
            in[k]=tempArray[i];// copy remaining sorted array
            i++;
            k++;
        }

    }

    public static void parallelMergeSort(int[] in,int low, int high, int numOfThreads){
        if (numOfThreads<=1){
            sort(in,low, high);
            return;
        }
        int mid = low+(high-low)/2;
        Thread leftSorter = startThread(in,low,mid,numOfThreads);
        Thread rightSorter = startThread(in,mid+1 ,high ,numOfThreads );

        leftSorter.start();
        rightSorter.start();

        try {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        merge(in, low, mid, high);
    }

    private static Thread startThread(int[] in, int low, int high, int numOfThreads) {
        return new Thread(){
            @Override
            public void run() {
                parallelMergeSort(in, low, high, numOfThreads/2);
            }
        };
    }

    public static void main(String[] args) {
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        int[] in = createRandomArray();
        int[] in1 = new int[in.length];
        for (int i = 0; i < in1.length; i++) {
            in1[i]=in[i];
        }
        tempArray = new int[in.length];
        long start = System.currentTimeMillis();
        parallelMergeSort(in,0,in.length-1,numOfThreads);
        long end = System.currentTimeMillis();
        System.out.printf("Parallel sorting time %d",(end-start));
        System.out.println();
//        System.out.println(Arrays.toString(in));

        long seqStart = System.currentTimeMillis();
        sort(in1,0,in1.length-1);
        long seqEnd = System.currentTimeMillis();
        System.out.printf("Sequential sorting time %d",(seqEnd-seqStart));
        System.out.println();
//        System.out.println(Arrays.toString(in1));

    }

    private static int[] createRandomArray() {
        int n = 100000000;
        Random random = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(1000);
        }        
        return a;
    }
}
