package com.test.prs.challenges;

public class FindMissingNUmber {
    public static void main(String[] args) {
        int[] arr = {5,1,4};
        solve(arr);
    }

    private static void solve(int[] arr) {
        sort(arr);
        int length = arr.length;
        int curr=arr[0];int i = 0;
        while(i<length){
            if(arr[i]!=curr){
                System.out.println(curr);
            }
            else
                i++; // increment i only when arr[i]==curr
            curr++;
        }

    }

    static void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j])
                    swap(arr,i,j);
            }
        }
    }

    private static  void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
