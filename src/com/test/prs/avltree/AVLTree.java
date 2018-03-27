package com.test.prs.avltree;

public class AVLTree {
    public Node root;
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
        if (balanceFactor>1 && data<node.left.data)// left left
            return rightRotate(node);
        if (balanceFactor>1 && data>node.left.data) {// left right
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor<-1 && data>node.right.data)// right right
            return leftRotate(node);
        if (balanceFactor<-1 && data<node.right.data){// right left
            node.right=rightRotate(node.right);
            return leftRotate(node);
        }
        return node; }

        public boolean search(Node node, int k){
            if (node==null)
                return false;
            if (node.data==k)
                return true;
            else if (k<node.data)
                return search(node.left,k);
            else
                return search(node.right,k);
        }

    public Node delete(Node node, int data){
        if (node==null)
            return null;
        if (data<node.data)
            node.left = delete(node.left,data);
        else if (data>node.data)
            node.right = delete(node.right,data);
        else {//no child or one child
            if (node.left == null || node.right == null) {
                Node temp = null;
                if (temp == node.left)
                    temp = node.right;
                else
                    temp = node.left;

                if (temp == null) {//no child
                    temp = node;
                    node = null;
                } else
                    node = temp;//one child
            } else {
                // both child
                //get inorder successor
                Node successor = getInorderSuccessor(node.right);
                node.data = successor.data;
                node.right = delete(node.right, successor.data);
            }
        }
            if (node==null)
                return null;

            node.height = 1+Math.max(height(node.left), height(node.right));

            int balanceFactor = getBalanceFactor(node);

            if (balanceFactor>1 && getBalanceFactor(node.left)>=0)//left left
                return rightRotate(node);
            if (balanceFactor>1 && getBalanceFactor(node.left)<0) {//left right
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
            if (balanceFactor<-1 && getBalanceFactor(node.right)<=0)//right right
                return leftRotate(node);
            if (balanceFactor<-1 && getBalanceFactor(node.right)>0){//right left
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }

        return node;
    }

    private Node getInorderSuccessor(Node node) {
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height =  Math.max(height(x.left), height(x.right)) + 1;
        y.height =  Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
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
        /*tree.root=tree.insert(tree.root,10);
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
        System.out.println();*/

        tree.root = tree.insert(tree.root, 9);
        printPreorder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, 5);
        printPreorder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, 10);
        printPreorder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, 0);
        printPreorder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, 6);
        printPreorder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, 11);
        printPreorder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, -1);
        printPreorder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, 1);
        printPreorder(tree.root);
        System.out.println();
        tree.root = tree.insert(tree.root, 2);
        printPreorder(tree.root);
        System.out.println();
        System.out.println("*********************************");
        tree.root = tree.delete(tree.root,10 );
        printPreorder(tree.root);

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
        this.height=1;
    }
}
