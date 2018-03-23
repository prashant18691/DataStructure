package com.test.prs.array;

public class MediansInTwoSortedArrays {

    public static double findMedian(int[] arr1, int[] arr2){
        if (arr1.length>arr2.length)
            return findMedian(arr2,arr1);
        int x = arr1.length;
        int y = arr2.length;

        int l=0;
        int h =x;
        while (l<=h){
            int pX = (l+h)/2;
            int pY = (x+y+1)/2-pX;

            int maxLeftX = pX==0?Integer.MIN_VALUE:arr1[pX-1];
            int minRightX = pX==x?Integer.MAX_VALUE:arr1[pX];

            int maxLeftY = pY==0?Integer.MIN_VALUE:arr2[pY-1];
            int minRightY = pY==y?Integer.MAX_VALUE:arr2[pY];

            if (maxLeftX<=minRightY && maxLeftY<=minRightX){
                if ((x+y)%2==0)
                    return (double)(Math.max(maxLeftX,maxLeftY))+Math.min(minRightX,minRightY)/2;
                else
                    return (double)Math.max(maxLeftX,maxLeftY);
            }
            else if (maxLeftX>minRightY)
                h=pX-1;
            else
                l=pX+1;
        }


        return 0.0;

    }

    public static void main(String[] args) {
        int[] arr1 = {2,5,7,11};
        int[] arr2 = {1,3,4,9,12};
        System.out.println(MediansInTwoSortedArrays.findMedian(arr1,arr2));
    }
}
