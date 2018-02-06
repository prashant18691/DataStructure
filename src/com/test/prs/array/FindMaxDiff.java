package com.test.prs.array;

public class FindMaxDiff {

    public static int solve(int[] arr){
        int max_diff = arr[1]-arr[0];
        int min = arr[0];
        for(int i=1;i<arr.length;i++){// 2 3 4 1
            if(arr[i]-min>max_diff){
                max_diff=arr[i]-min;
            }
            if(min>arr[i])
                min=arr[i];
        }
        return max_diff;
    }
    public static void main(String[] args) {
        System.out.println(solve(new int[]{2,3,4,1}));
    }
}
