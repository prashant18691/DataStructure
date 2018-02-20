package com.test.prs.binarytree;

public class TestBalanced {
    Node root;

    public static boolean isBalanced(Node n, Height h){
        if (n==null){
            h.height=0;
            return true;
        }
        Height lh = new Height(),rh = new Height();
        boolean l = isBalanced(n.left,lh);
        boolean r = isBalanced(n.right,rh);
        h.height = Math.max(lh.height,rh.height)+1;
        if (Math.abs(lh.height-rh.height)>1)
            return false;
        return l&&r;
    }
    public static void main(String[] args) {
        Height height = new Height();

        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        TestBalanced tree = new TestBalanced();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
//        tree.root.right.right = new Node(6);
        tree.root.left.left.left = new Node(7);

        if (tree.isBalanced(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}

class Height{
    int height;
}