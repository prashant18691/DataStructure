package com.test.prs.bst.impl;

public class BST {
    public Node root;
    public Node add(Node node, int k){
        if (node==null)
            return new Node(k);
        if (node.data>k)
            node.left=add(node.left,k);
        else if (node.data<k){
            node.right=add(node.right,k);
        }
        else
            return node;//duplicate node
        return node;
    }

    public boolean search(Node node, int k){
        if (node==null)
            return false;
      /*  if (node.data==k)
                return true;
        if (k<=node.data)
            return search(node.left,k);
        else
            return search(node.right,k);*/
      boolean found = false;
      while (node!=null && !found){
          if (node.data==k)
              found =true;
          else if (k<node.data)
              node=node.left;
          else node = node.right;
        }
        return found;
    }

    public Node delete(Node node, int k){
        if (node==null)
            return null;
        if (node.data==k){
            if (node.left==null && node.right==null)
                return null;
            else if (node.left==null)
                return node.right;
            else if (node.right==null)
                return node.left;
            else {
                Node p1 = node.right;
                Node p = node.right;
                while (p.left!=null)
                    p=p.left;

               /* node.data=p.data;
                node.right=delete(node.right,node.data);
                return node;*/
               // or
                p.left=node.left;
                return p1;
            }

        }
        else if (node.data>k)
            node.left = delete(node.left,k);
        else
            node.right = delete(node.right,k);
        return node;
    }

    /*

             10
          /       \
        4          15
       / \        /
      2   7      12
     / \  /\     / \
    1  3 5  8   11  14
          \  \      /
           6  9    13


     */

    public static void main(String[] args) {
        BST bst =new BST();
        bst.root = bst.add(bst.root,10);
        bst.root = bst.add(bst.root,4);
        bst.root = bst.add(bst.root,2);
        bst.root = bst.add(bst.root,1);
        bst.root = bst.add(bst.root,3);
        bst.root = bst.add(bst.root,7);
        bst.root = bst.add(bst.root,8);
        bst.root = bst.add(bst.root,9);
        bst.root = bst.add(bst.root,5);
        bst.root = bst.add(bst.root,6);
        bst.root = bst.add(bst.root,15);
        bst.root = bst.add(bst.root,12);
        bst.root = bst.add(bst.root,11);
        bst.root = bst.add(bst.root,14);
        bst.root = bst.add(bst.root,13);
        printInorder(bst.root);
     //   System.out.println(bst.search(bst.root,6));
        bst.delete(bst.root,4);
        printInorder(bst.root);
    }

    private static void printInorder(Node node) {
        if (node==null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}
