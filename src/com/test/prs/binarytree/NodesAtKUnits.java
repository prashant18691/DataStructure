package com.test.prs.binarytree;

import java.util.ArrayList;
import java.util.List;

public class NodesAtKUnits {
    static Node root;
    static List<Node> list = new ArrayList<>();

    public static void findKNodes(Node node, int k) {
        if (node == null || k < 0)
            return;
        if (k == 0)
            list.add(node);
        if (node.left != null)
            findKNodes(node.left, k - 1);
        if (node.right != null)
            findKNodes(node.right, k - 2);
    }

    public static void main(String[] args) {
        root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.right = new Node(35);
        root.right.left = new Node(55);
        root.right.right = new Node(70);
        findKNodes(root, 4);
        for(Node i : list)
            System.out.print(i.data+" ");
    }
}
