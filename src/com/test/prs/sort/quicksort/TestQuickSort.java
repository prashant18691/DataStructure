package com.test.prs.sort.quicksort;

import java.util.Arrays;

public class TestQuickSort {

    class Index{
        int i,j;
    }

    public void doSort(int[] in){
        if(in==null)
            return;
        int h = in.length-1;
        sort(in,0,h);
    }

    private void sort(int[] in,int l,int h){
        if(l<h){
            int pi =partition(in,l,h);
            sort(in,l,pi-1);
            sort(in,pi+1,h);
        }
    }

    private int partition(int[] in, int l, int h) {
       int pivot = in[h];
       int i=l-1;
       for(int j=l;j<h;j++){
            if(in[j]<pivot){
                i++;
                swap(in,i,j);
            }
       }
       int temp = in[i+1];
        in[i+1] = in[h];
        in[h] = temp;

        return i+1; // return pivot index
    }

    private void swap(int[] in, int i, int j) {
        int temp = in[i];
        in[i] = in[j];
        in[j] = temp;
    }

    public void doQuickSort(int[] in){
        if(in==null)
            return;
        int h = in.length-1;
        sort_quick(in,0,h);
    }

    private void sort_quick(int[] in, int l, int h) {
        if(l<h){
            Index index = new Index();
            partition_3way(in,l,h,index);
            sort_quick(in,l,index.i);
            sort_quick(in,index.j,h);
        }
    }

    private void partition_3way(int[] in, int l, int h, Index index) {
        if(h-l<=1){
            if(in[l]>in[h])
                swap(in,l,h);
            index.i=l;
            index.j=h;
            return;
        }
        int mid=l;
        int pivot = in[h];
        while(mid<=h){
            if(in[mid]<pivot)
                swap(in,l++,mid++);
            else if(in[mid]==pivot)
                mid++;
            else if(in[mid]>pivot)
                swap(in,mid,h--);
        }
        index.i=l-1;
        index.j=mid;
    }

    public static void main(String[] args){
        TestQuickSort sort = new TestQuickSort();
        int[] in = {2,1,2,0,0,1,1};
        sort.doQuickSort(in);

        System.out.println(Arrays.toString(in));
    }
}
