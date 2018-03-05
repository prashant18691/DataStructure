package com.test.prs.avltree;

public class AVLTree {
    Node root;
    public Node insert(Node node,int data){
        if (node==null)
            return new Node(data);
        if (data<node.data)
            node.left=insert(node.left,data);
        else if (data>node.data)
            node.right=insert(node.right,data);
        else
            return node;// duplicate node
        node.height=1+Math.max(height(node.left),height(node.right));
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor>0 && data<node.left.data)// left left
            return rightRotate(node);
        if (balanceFactor>0 && data>node.left.data) {// left right
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor<0 && data>node.right.data)// right right
            return leftRotate(node);
        if (balanceFactor<0 && data<node.right.data){// right left
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node leftRotate(Node node) {
//        System.out.print("left ");
        Node y = node.right;
        Node t1 = y.left;
        node.right=t1;
        y.left=node;
        node.height=1+Math.max(height(node.left),height(node.right));
        y.height=1+Math.max(height(y.left),height(y.right));
        return y;
    }

    private Node rightRotate(Node node) {
//        System.out.print("right ");
        Node y = node.left;
        Node t1 = y.right;
        node.left=t1;
        y.right=node;
        node.height=1+Math.max(height(node.left),height(node.right));
        y.height=1+Math.max(height(y.left),height(y.right));
        return y;
    }

    private int getBalanceFactor(Node node) {
        if (node==null)
            return 0;
        return height(node.left)-height(node.right);
    }

    private int height(Node node) {
        if (node==null)return 0;
        return node.height;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.root=tree.insert(tree.root,10);
        printPreorder(tree.root);
        System.out.println();
        tree.root=tree.insert(tree.root,20);
        printPreorder(tree.root);
        System.out.println();
        tree.root=tree.insert(tree.root,30);
        printPreorder(tree.root);
        System.out.println();
        tree.root=tree.insert(tree.root,40);
        printPreorder(tree.root);
        System.out.println();
        tree.root=tree.insert(tree.root,50);
        printPreorder(tree.root);
        System.out.println();
        tree.root=tree.insert(tree.root,25);
        printPreorder(tree.root);
        System.out.println();
    }

    private static void printPreorder(Node root) {
        if (root==null) return;
        System.out.print(root.data+" ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}

class Node{
    int data,height;
    Node left,right;

    public Node(int data) {
        this.data = data;
    }
}
