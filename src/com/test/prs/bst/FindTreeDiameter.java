package com.test.prs.bst;

public class FindTreeDiameter {
    /*The diameter of a tree T is the largest of the following quantities:
      the diameter of T’s left subtree
* the diameter of T’s right subtree
* the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
* TC :: O(n)
* */
    Node root;

    class Height{
        int height;
    }

    int diameter(){
        Height h = new Height();
        return findDiameter(root,h);
    }

    private int  findDiameter(Node node, Height h) {
        if(node==null) {
            h.height=0;
            return 0;
        }
        Height lh = new Height();
        Height rh = new Height();
        int lDiameter = findDiameter(node.left,lh);
        int rDiameter = findDiameter(node.right,rh);

        h.height = Math.max(lh.height,rh.height)+1;
        return Math.max(Math.max(lDiameter,rDiameter),lh.height+rh.height+1);
    }

    public static void main(String[] args) {
        FindTreeDiameter tree = new FindTreeDiameter();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
       /* tree.root.right.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.root.right.right.right.left = new Node(10);
        tree.root.right.right.right.right = new Node(11);
        tree.root.right.right.right.left.left = new Node(12);
        tree.root.right.right.right.left.right = new Node(13);*/
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
     /*   tree.root.left.right.left = new Node(6);
        tree.root.left.right.right = new Node(7);*/
        System.out.println(tree.diameter());
    }
}
