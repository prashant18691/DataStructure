package com.test.prs.bst;

import java.util.Arrays;


public class PrintPostOrder {
    public static void printPostOrder(int[] pre, int[] in){
        int rootIndex = search(in,pre[0]);
        if(rootIndex!=0)
            printPostOrder(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(in,0,rootIndex)); // print left subtree
        if(rootIndex!=in.length-1)
            printPostOrder(Arrays.copyOfRange(pre,rootIndex+1,pre.length),Arrays.copyOfRange(in,rootIndex+1,in.length));
        System.out.print(pre[0]+" ");
    }

    private static int search(int[] arr, int k){
        for(int i=0;i<arr.length;i++)
            if(arr[i]==k)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6};
        int[] in = {4, 2, 5, 1, 3, 6};
        PrintPostOrder.printPostOrder(pre,in);
    }
}
