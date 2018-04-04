package com.test.prs.binarytree;

public class RemoveLeafNode {
    Node root;
    public Node removeLeaf(Node node){
        if(node==null) return null;
        if(node.left==null && node.right==null)
            return null;
        node.left = removeLeaf(node.left);
        node.right = removeLeaf(node.right);
        return node;

    }

    public static void main(String[] args) {
        RemoveLeafNode tree = new RemoveLeafNode();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.root.right.right.right.left = new Node(10);
        tree.root.right.right.right.right = new Node(11);
        tree.root.right.right.right.left.left = new Node(12);
        tree.root.right.right.right.left.right = new Node(13);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root = tree.removeLeaf(tree.root);
        printInorder(tree.root);
    }

    private static void printInorder(Node root) {
        if (root==null) return;
        System.out.print(root.data+" ");
        printInorder(root.left);
        printInorder(root.right);
    }
}
