package com.test.prs.binarytree;

import java.util.Vector;

public class BalanceTree {// normal bst to balance bst
    Node root;
    void balanceTree(){
        Vector<Node> nodes = new Vector<>();
        storeTree(root,nodes);
        root = balanceTreeUtil(nodes,0,nodes.size()-1);
    }

    private Node balanceTreeUtil(Vector<Node> nodes, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        Node node = nodes.get(mid);
        node.left = balanceTreeUtil(nodes,l,mid-1);
        node.right = balanceTreeUtil(nodes,mid+1,r);
        return node;
    }

    private void storeTree(Node node, Vector<Node> nodes) {
        if (node==null)
            return;
        storeTree(node.left,nodes);
        nodes.add(node);
        storeTree(node.right,nodes);
    }

    public static void main(String[] args) {
        BalanceTree tree = new BalanceTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(7);
        tree.root.left.left.left = new Node(6);
        tree.root.left.left.left.left = new Node(5);

        tree.balanceTree();
        System.out.println("Preorder traversal of balanced BST is :");
        tree.preOrder(tree.root);
    }

    private void preOrder(Node node) {
        if (node==null)
            return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
