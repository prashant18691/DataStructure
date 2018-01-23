package com.test.prs.sort.mergesort;

import java.util.Arrays;

public class FindInversionCount { //elements smaller than current at RHS
    int N;
    public FindInversionCount(int n){
        N = n;
        temp = new int[N];
    }
    int[] temp;

    int mergeSort(int[] arr, int l, int h){
        int invCount = 0;
        if(l<h){
            int mid = (l+h)/2;
            invCount = mergeSort(arr,l,mid);
            invCount+= mergeSort(arr, mid+1,h);
            invCount+= merge(arr,l,mid,h);
        }
        return invCount;
    }

    private int merge(int[] arr, int l, int mid, int h) {
        int invCount = 0;
        for(int i=l;i<=h;i++)
            temp[i]=arr[i];
        int i = l;
        int k = l;
        int j = mid+1;
        int c = 0;
        while (i<=mid && j<=h){
            if(temp[i]<temp[j]){
                arr[k] = temp[i];
                i++;
            }
            else{
                arr[k] = temp[j];
                j++;
                invCount += mid+1-i;
                c++;
            }
            k++;
        }
        while(i<=mid){
            arr[k]=temp[i];
            k++;
            i++;
        }
        return invCount;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 7, 5, 3, 0, 8, 1};
        FindInversionCount f = new FindInversionCount(arr.length);
        System.out.println("Number of inversions are " +f.mergeSort(arr,0,arr.length-1));
        System.out.println(Arrays.toString(arr));
    }
}
