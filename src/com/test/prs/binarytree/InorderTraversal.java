package com.test.prs.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InorderTraversal {
    Node root;
    void inorderTraversalWithoutRecussion(){
        if(root==null)
            return;

        Stack<Node> s = new Stack<>();
        Node curr = root;
        while(curr!=null){
            s.push(curr);
            curr=curr.left;
        }
        while(!s.empty()){
            curr = s.pop();
            System.out.print(curr.data+" ");
            if (curr.right!=null) {
                curr = curr.right;
                while (curr != null) {
                    s.push(curr);
                    curr = curr.left;
                }
            }
        }
    }

    public void lot(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while (queue.size()!=0){
            Node n = queue.poll();
            if (n == null) {
                System.out.println();
                continue;
            } else {
                System.out.print(n.data+" ");
            }
            if (n.left!=null)
                queue.add(n.left);
            if (n.right!=null);
                queue.add(n.right);
            queue.add(null);
        }
    }

    public static void main(String[] args) {
        InorderTraversal tree = new InorderTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inorderTraversalWithoutRecussion();

        System.out.println("**********************Level Order Traversal*********");
        tree.lot(tree.root);
    }
}
