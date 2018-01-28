package com.test.prs.challenges.amazon;


public class FindTreeDiameter {
    BTNode root;

    private class Height{
        int height;
    }

    public int findDiameter(){
        Height h = new Height();
        return diameter(root,h);
    }

    private int diameter(BTNode node,Height h) {
        if(node==null) {
            h.height = 0;
            return 0;
        }
        Height  lh = new Height();
        Height  rh = new Height();
        int lDiameter = diameter(node.left,lh);
        int rDIameter = diameter(node.right,rh);
        h.height = Math.max(lh.height,rh.height)+1;
        return Math.max(Math.max(lDiameter,rDIameter),lh.height+rh.height+1);
    }

    public static void main(String[] args) {
        FindTreeDiameter tree = new FindTreeDiameter();
        tree.root = new BTNode(1);
        tree.root.left = new BTNode(2);
        tree.root.right = new BTNode(3);
        tree.root.right.right = new BTNode(8);
        tree.root.right.right.right = new BTNode(9);
        tree.root.right.right.right.left = new BTNode(10);
        tree.root.right.right.right.right = new BTNode(11);
        tree.root.right.right.right.left.left = new BTNode(12);
        tree.root.right.right.right.left.right = new BTNode(13);
        tree.root.left.left = new BTNode(4);
        tree.root.left.right = new BTNode(5);
        tree.root.left.right.left = new BTNode(6);
        tree.root.left.right.right = new BTNode(7);
        System.out.println(tree.findDiameter());
        
    }
}

class BTNode{
    int data;
    BTNode left,right;

    public BTNode(int data) {
        this.data = data;
    }
}
