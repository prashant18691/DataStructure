package com.test.prs.algorithms;
//O(n)
public class QuickSelect {
    public static int findKthSmallest(int[] arr, int indexFirst, int indexLast, int k){
        if (indexFirst>indexLast)
            return -1;
        int pivot = partition(arr, indexFirst, indexLast);
        if (pivot<k)
            return findKthSmallest(arr, pivot+1, indexLast, k);
        else if (pivot>k)
            return findKthSmallest(arr, indexFirst, pivot-1, k);

        return arr[pivot];
    }

    static int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    private static int partition(final int[] arr,  int indexFirst, int indexLast) {
        int pivot = randomWithRange(indexFirst, indexLast);
        swap(arr, indexLast, pivot);
        for (int i = indexFirst; i < indexLast; i++) {
            if (arr[i] > arr[indexLast]){   // arr[i] > arr[indexLast] --> kth  largest--> left side contains greater
                // elements than pivot
                swap(arr, i, indexFirst);   // arr[i] < arr[indexLast] --> kth smallest --> left side contains
                // smaller elements than pivot
                indexFirst++;
            }
        }
        swap(arr, indexFirst, indexLast);

        return indexFirst;
    }

    private static void swap(final int[] arr, final int indexLast, final int pivot) {
        int temp = arr[indexLast];
        arr[indexLast] = arr[pivot];
        arr[pivot] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,5,8,7,6};
        int k = 1;
        System.out.println(findKthSmallest(arr, 0, arr.length-1, k-1));
    }
}
