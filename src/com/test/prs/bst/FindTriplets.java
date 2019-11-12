package com.test.prs.bst;

import com.test.prs.bst.impl.BST;
import com.test.prs.bst.impl.Node;


public class FindTriplets {//O(n2)
    com.test.prs.bst.impl.Node root;
    int[] arr; int i = 0;
    public void findTripletsNaive(com.test.prs.bst.impl.Node node, int sum){
        arrayInSortedOrder(node);
        for (int j = 0; j < arr.length-2; j++) {
            int l = j+1;
            int r = arr.length-1;
            while (l<r){
                if(arr[j]+arr[l]+arr[r]==sum){
                    System.out.println("Triplets are : "+arr[j]+ " "+arr[l]+" "+arr[r]);
                    return;
                }
                else if (arr[i]+arr[l]+arr[r]<sum){
                    l++;
                }
                else {
                    r--;
                }
            }
        }
    }

    private void arrayInSortedOrder(final com.test.prs.bst.impl.Node node) {
        int length = getLength(node);
        arr = new int[length];
        inorderTraversal(node);
    }

    private void inorderTraversal(final Node node) {
        if (node==null) return;
        inorderTraversal(node.left);
        arr[i++] = node.data;
        inorderTraversal(node.right);
    }

    int getLength(com.test.prs.bst.impl.Node node){
        if (node==null) return 0;
        return 1 + getLength(node.right) + getLength(node.left);
    }

    public static void main(String[] args) {
        FindTriplets findTriplets = new FindTriplets();
        BST bst = new BST();
        bst.root = bst.add(bst.root,20);
        bst.root = bst.add(bst.root,8);
        bst.root = bst.add(bst.root,22);
        bst.root = bst.add(bst.root,4);
        bst.root = bst.add(bst.root,12);
        bst.root = bst.add(bst.root,10);
        bst.root = bst.add(bst.root,14);
        findTriplets.root = bst.root;
        findTriplets.findTripletsNaive(findTriplets.root, 34);
    }
}
