package com.test.prs.bst.surpasserCount;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindSurpasserCount { // elements greater than current at RHS
    NodeInv root;
    int N;

    public FindSurpasserCount(int n) {
        N = n;
    }

    void add(int n){
        root = addNode(root,n);
    }

    NodeInv addNode(NodeInv node,int n){
        if(node==null)
            node = new NodeInv(n);
        else{
            if(n<node.data){
                node.left = addNode(node.left,n);
                node.invCount++;
            }
            else {
                node.right = addNode(node.right, n);
            }
        }

     return node;
    }



    public static void main(String[] args) {
        int arr[] = new int[]{2, 7, 5, 3, 0, 8, 1};
        int length = arr.length;
        FindSurpasserCount f = new FindSurpasserCount(arr.length);
        int[] output =  f.findSurpasser(arr, length);
        System.out.println(Arrays.toString(output));
        f.bfs(f.root);
    }

    private  int[] findSurpasser(int[] arr, int length) {
        int[] output  = new int[length];
        for(int i=length-1;i>=0;i--) {
            int surr = 0;
            add(arr[i]);
            surr = countGreater(root,arr[i]);
            output[i]=surr;
        }
        return output;
    }

    private int countGreater(NodeInv root, int x) {
        if(root == null) return 0;
        int t;
        if( root.data == x ) return count(root.right);
        if(root.data > x) //If greater found, count all child nodes in its right subtree, count this node itself also and move to its left subtree
        {
            int num_till_here = 1 + count(root.right);
            t = countGreater(root.left, x);
            return (t + num_till_here);
        }
        else if(root.data < x) //Keep moving to the right if node with greater value than required still not found
        {
            t = countGreater(root.right, x);
            return t;
        }
        return 0;
    }

    private int count(NodeInv n) {
        if(n==null)
            return 0;
        return 1 + count(n.left) + count(n.right);
    }

    private void bfs(NodeInv root) {
        if(root==null)
            return;
        Queue<NodeInv> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            NodeInv node = q.poll();
            System.out.println(node.data+" "+node.invCount);
            if(node.left!=null)
            q.add(node.left);
            if(node.right!=null)
            q.add(node.right);
        }
    }
}

class NodeInv{
    int invCount;
    int data;
    NodeInv left,right;

    public NodeInv(int data) {
        this.data = data;
    }
}
