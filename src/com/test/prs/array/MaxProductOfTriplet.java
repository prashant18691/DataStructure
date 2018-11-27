package com.test.prs.array;

public class MaxProductOfTriplet {
    public static int solve(int[] arr){
        if (arr.length<3)
            return -1;
        if (arr.length==3)
            return arr[0]*arr[1]*arr[2];
        int maxA = Integer.MIN_VALUE,maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>maxA){
                maxC = maxB;
                maxB = maxA;
                maxA = arr[i];
            }
            else if (arr[i]>maxB){
                maxC = maxB;
                maxB = arr[i];
            }
            else if (arr[i]>maxC){
                maxC = arr[i];
            }

            if (arr[i]<minA){
                minB = minA;
                minA = arr[i];
            }
            else if (arr[i]<minB){
               minB = arr[i];
            }
        }
        return Math.max(minA*minB*maxA, maxA*maxB*maxC);
    }

    public static void main(String[] args) {
        int[] arr = {1, -4, 3, -6, 7, 0};
        System.out.println(solve(arr));
    }
}
