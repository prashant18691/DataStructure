package com.test.prs.bst;


import com.test.prs.bst.impl.BST;

public class LowestCommonAncestor {
    public static com.test.prs.bst.impl.Node findLCA(com.test.prs.bst.impl.Node node, int n1, int n2){
        if (node==null)
            return null;
        if (n1<node.data && n2<node.data)
            return findLCA(node.left,n1,n2);
        if (n1>node.data && n2>node.data)
            return findLCA(node.right,n1,n2);
        return node;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.root = bst.add(bst.root,20);
        bst.root = bst.add(bst.root,8);
        bst.root = bst.add(bst.root,22);
        bst.root = bst.add(bst.root,4);
        bst.root = bst.add(bst.root,12);
        bst.root = bst.add(bst.root,10);
        bst.root = bst.add(bst.root,14);
        System.out.println(findLCA(bst.root,10,14).data);
    }
}


