package com.test.prs.array;

import com.test.prs.sort.HeapSort;


public class TrainPlatform {
    public int solve(int[] arr, int[] dep, int n){
        HeapSort sort = new HeapSort();
        int[] arrSorted = sort.sort(arr);
        int[] depSorted = sort.sort(dep);
        int result = 1; int i = 1; int j = 0;
        int count = 1;
        while (i<n && j<n){
            if (arrSorted[i]<= depSorted[j]){
                count++;i++;
                if (result<count){
                    result = count;
                }
            }
            else{
                count--;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TrainPlatform trainPlatform = new TrainPlatform();
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + trainPlatform.solve(arr, dep, n));
    }
}
