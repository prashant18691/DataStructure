package com.test.prs.sort;

class Pair
{
    int min;
    int max;
}

public class MinMaxSort { // doesn't give correct input


    public Pair getminmax(int[] arr,int low,int high)
    {
        Pair p=new Pair();

        if(low==high)
        {
            p.min=arr[low];
            p.max=arr[low];
            return p;
        }

        if((low+1)==high)
        {

            if(arr[low]<arr[high])
            {
                p.min=arr[low];
                p.max=arr[high];
            }

            if(arr[low]>arr[high])
            {
                p.min=arr[high];
                p.max=arr[low];
            }
            return p;
        }

        int mid=(low+high)/2;

        Pair mml=getminmax(arr, low, mid);
        Pair mmr=getminmax(arr, mid+1, high);

        if(mml.max<mmr.max)
        {
            p.max=mmr.max;
        }

        if(mml.max>mmr.max)
        {
            p.max=mml.max;
        }

        if(mml.min<mmr.min)
        {
            p.min=mml.min;
        }

        if(mml.min>mmr.min)
        {
            p.min=mmr.min;
        }
        return p;

    }

    public static void main(String[] args) {

        int arr[]={1,1,1,2,2};
        MinMaxSort mm = new MinMaxSort();
        Pair ans=mm.getminmax(arr, 0, arr.length-1);
        System.out.println("min is "+ans.min+" max is "+ans.max);
    }

}

