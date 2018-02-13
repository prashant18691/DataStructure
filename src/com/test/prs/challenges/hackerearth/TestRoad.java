package com.test.prs.challenges.hackerearth;

import java.util.Scanner;

public class TestRoad {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = s.nextInt();
        int count = 0;
        for(int i=0;i<n;i++)
            if(binarySearch(arr,i+1,n-1,arr[i]+k)!=-1)
                count++;
        System.out.println(count);
    }

    private static int binarySearch(int[] arr, int l, int h, int o) {
        if(l<=h){
            int mid = (l+h)/2;
            if(arr[mid]==o)
                return mid;
            if(arr[mid]<o)
                return binarySearch(arr,l,mid-1,o);
            if(arr[mid]>o)
                return binarySearch(arr,mid+1,h,o);
        }
        return -1;
    }
}
