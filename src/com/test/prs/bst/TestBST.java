package com.test.prs.bst;

public class TestBST {

    Node root;
    Node previous;
    boolean add(int data){
        int oldNodeCount = countNodes(root);
        root = add(root,data);
        int newNodeCount = countNodes(root);
        return newNodeCount-oldNodeCount>0;
    }
    Node add(Node n,int data){
        if(n==null) {
            n = new Node(data);
        }
        else {
            if(data<n.data)
            n.left = add(n.left,data);
            else
            n.right = add(n.right,data);
        }
        return n;
    }
    private int countNodes(Node node) {
        if(node==null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    boolean verifyBST(){
        return isBST(root);
    }
    boolean isBST(Node node){// in-order traversal
        if(node==null)
            return true;
        if(!isBST(node.left))
            return false;
        if(previous!=null && previous.data>=node.data)// check if parent data > right node data
            return false;
        previous = node;
        return isBST(node.right);
    }
    public static void main(String[] args){
        TestBST test = new TestBST();
        test.add(4);
        test.add(2);
        test.add(5);
        test.add(1);
        test.add(3);
        boolean isBst = test.verifyBST();
        if(isBst)
            System.out.println("Given tree is a valid BST");
        else
            System.out.println("Given tree is not a valid BST");
    }
}
