package com.test.prs.sort.mergesort;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] in = {6,2,6,4,5,2};
        tempArray = new int[in.length];
        sort(in,0,in.length-1);
        System.out.println(Arrays.toString(in));
    }
}
