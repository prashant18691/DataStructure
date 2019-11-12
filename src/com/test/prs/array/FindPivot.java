package com.test.prs.array;

public class FindPivot {// pivot where all the elements on left is small and elements on right are large.
    public int solve(int[] arr, int n){//tc O(n); sc O(n)
        if (n==0) return -1;
        if (n==1) return 0;
        int[] left_max = new int[n];
        left_max[0] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(arr[i-1],left_max[i-1]);
        }
        int right_min = Integer.MAX_VALUE;
        for (int i = n-1; i >= 0 ; i--) {
            if (arr[i]>left_max[i] && arr[i]<right_min){
                return i;
            }
            right_min = Math.min(arr[i],right_min);
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivot pivot = new FindPivot();
        int[] arr = {5,1,4,3,6,8,10,7,9};
        System.out.println(pivot.solve(arr, arr.length));
    }
}
