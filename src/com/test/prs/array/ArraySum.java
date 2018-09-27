package com.test.prs.array;

public class ArraySum {

    public int[] sum(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int r = Math.max(n,m);
        int[] result = new int[r];
        int sum = 0;
        int carry = 0;
        int i = n-1;
        int j = m-1;
        r--;
        while (i>=0 && j>=0){
            sum = arr1[i--]+arr2[j--]+carry;
            carry = sum/10;
            result[r--] = sum%10;
        }
        while (i>=0){
            sum = arr1[i--]+carry;
            carry = sum/10;
            result[r--] = sum%10;
        }
        while (j>=0){
            sum = arr1[j--]+carry;
            carry = sum/10;
            result[r--] = sum%10;
        }
        if (carry!=0){
            int[] newResult = new int[result.length+1];
            for (int k = newResult.length-1; k >=1 ; k--) {
                newResult[k] = result[k-1];
            }
            newResult[0]=carry;
            return newResult;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = {9,9,9,9,9,9,9};
        int arr2[] =   {1,6,8,2,6,7};
        ArraySum aa = new ArraySum();
        int result[] = aa.sum(arr1, arr2);
        for(int i=0; i < result.length; i++){
            System.out.print(" " + result[i]);
        }
    }
}
