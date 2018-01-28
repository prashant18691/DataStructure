package com.test.prs.array;

public class MaxContiguousSubArray {
    public static int findSum(int[] arr){
        int max_so_far =0, max_ending_here = 0;
        for(int i=0;i<arr.length;i++){
            max_ending_here += arr[i];
            if(max_ending_here<0)
                max_ending_here=0;
            else {
                if(max_ending_here>max_so_far)
                    max_so_far = max_ending_here;
            }
        }
        return max_so_far;
    }

    public static int findSum2(int[] arr){
        int max_so_far =arr[0], curr_max = arr[0];
        for(int i=1;i<arr.length;i++){
            curr_max = Math.max(arr[i],arr[i]+curr_max);
            max_so_far = Math.max(max_so_far,curr_max);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, -4, -1, -2, -1, -5, -3};
        System.out.println(findSum2(arr));
    }
}
