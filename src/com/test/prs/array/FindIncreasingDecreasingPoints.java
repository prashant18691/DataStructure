package com.test.prs.array;

public class FindIncreasingDecreasingPoints {
    public static int solveFirstIncreasing(int[] arr, int start, int end){
        if (arr==null || arr.length==0)
            return -1;
        if (start==end)
            return start;
        if (start+1==end && arr[start]>arr[end])
            return start;
        if (start+1==end && arr[start]<arr[end])
            return end;
        int mid = (start+end)/2;
        if (arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
            return mid;
        if (arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1])
            return solveFirstIncreasing(arr,mid+1,end);
        if (arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1])
            return solveFirstIncreasing(arr,start,mid-1);
        return -1;
    }

    public static int solveFirstDecreasing(int[] arr, int start, int end){
        if (arr==null || arr.length==0)
            return -1;
        if (start==end)
            return start;
        if (start+1==end && arr[start]>arr[end])
            return end;
        if (start+1==end && arr[start]<arr[end])
            return start;
        int mid = (start+end)/2;
        if (arr[mid]<arr[mid-1] && arr[mid]<arr[mid+1])
            return mid;
        if (arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1])
            return solveFirstDecreasing(arr,start,mid-1);
        if (arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1])
            return solveFirstDecreasing(arr,mid+1,end);
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 50, 10, 9, 7, 6};
        if (arr.length>1) {
            if (arr[0]>arr[1])
                System.out.println(arr[solveFirstDecreasing(arr, 0, arr.length - 1)]);
            else
                System.out.println(arr[solveFirstIncreasing(arr, 0, arr.length - 1)]);
        }
    }
}
