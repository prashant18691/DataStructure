package com.test.prs.array;

public class FindFirstLastOccurrenceInSortedArray {
    public static void findOccurence(int[] arr, int x){
        int first = findFirstOccurrence(arr,0,arr.length-1,x,arr.length);
        int last = findLastOccurence(arr,0,arr.length-1,x,arr.length);
        System.out.println(first+" "+ last);
    }
    static int findFirstOccurrence(int[] arr,int l,int h,int x, int n){
        if(l<=h){
            int mid= (l+h)/2;
            if((mid==0 || arr[mid-1]<x )&& arr[mid]==x)
                return mid;
            else if(x<=arr[mid]){
                return findFirstOccurrence(arr,l,mid-1,x,n);
            }
            else
                return findFirstOccurrence(arr,mid+1,h,x,n);
        }
        return -1;
    }

    static int findLastOccurence(int[] arr,int l,int h,int x, int n){
        if(l<=h){
            int mid=(l+h)/2;
            if((mid==n-1 || arr[mid+1]>x) && arr[mid]==x)
                return mid;
            else if(x>=arr[mid])
                return findLastOccurence(arr,mid+1,h,x,n);
            else
                return findLastOccurence(arr,l,mid-1,x,n);
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 2, 2, 3, 4, 7,8, 8, 8};

        findOccurence(arr, 8);
    }
}
