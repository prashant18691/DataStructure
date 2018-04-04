package com.test.prs.binarytree;

public class FindDistance {
    public static int findDistance(Node n, int a, int b){
        return -1;
    }

    public static void main(String[] args) {
        Node  root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Dist(4, 5) = "+findDistance(root, 4, 5));
        System.out.println("Dist(4, 6) = "+findDistance(root, 4, 6));
        System.out.println("Dist(3, 4) = "+findDistance(root, 3, 4));
        System.out.println("Dist(2, 4) = "+findDistance(root, 2, 4));
        System.out.println("Dist(8, 5) = " +findDistance(root, 8, 5));
    }
}
