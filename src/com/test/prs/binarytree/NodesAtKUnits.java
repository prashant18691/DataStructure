package com.test.prs.binarytree;

import java.util.ArrayList;
import java.util.List;
//Print all nodes at distance k from a given node
public class NodesAtKUnits {
    static Node root;

    public static void findKNodes(Node node, int k) {
        if (node==null || k<0)
            return;
        if (k==0){
            System.out.println(node.data);
            return;
        }
        if (node.left!=null)
            findKNodes(node.left,k-1);
        if (node.right!=null)
            findKNodes(node.right,k-1);
    }

    public int findKNodes(Node node, Node target, int k){
        if (node==null || k<0)
            return -1;
        if (node==target){
            findKNodes(node, k);
            return 0;// dl or dr (distance of parent's left or right child from target)
        }

        int dl = findKNodes(node.left,target,k);
        if (dl!=-1){
            if (dl+1==k){// distance of parent(dl+1) node from target
                System.out.println(node.data);
            }
            else{
                findKNodes(node.right,k-dl-2);
            }
            return dl+1;
        }

        int dr = findKNodes(node.right, target, k);
        if (dr!=-1){
            if (dr+1==k){
                System.out.println(node.data);
            }
            else {
                findKNodes(node.left, k-dr-2);
            }
            return dr+1;
        }


        return -1;
    }

    public static void main(String[] args) {
        NodesAtKUnits nodesAtKUnits = new NodesAtKUnits();
        root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.left = new Node(41);
        root.right.left.left = new Node(27);
        root.right.left.right = new Node(6);
        root.right.right = new Node(121);
        root.right.right.left = new Node(0);
        root.right.right.right = new Node(1);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        Node target = root.left.right;
        nodesAtKUnits.findKNodes(root, target, 2);
    }
}
