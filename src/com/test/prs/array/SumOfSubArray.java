package com.test.prs.array;

public class SumOfSubArray {
    public static int findSum(int[] arr){//{1,2,3} ==> 1,2,3,{1,2},{2,3},{1,2,3};  (n+1)C2 combinations
        int sum = 0;
        int n = arr.length;// 1(i=0) appears first in (n-i) subarrays. i - index of 1;
        for (int i = 0; i < n; i++) {  // 2(i=1) appears first in (n-i) subarrays and appears at other place
            sum+=  arr[i]*(n-i) *(i+1);                            // in (n-i)*i subarrays
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 1, 1, -2, 1};
        System.out.println(findSum(arr));
    }
}
