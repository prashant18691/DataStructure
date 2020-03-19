package com.test.prs.binarytree.serialization.deserialization;

import java.util.ArrayList;

public class TestSerializeDeserializeTree {
    public static void main(String[] args) {
        SerializeDeserializeTree serializeDeserializeTree = new SerializeDeserializeTree();
        Tree root = new Tree(10);
        root.left = new Tree(20);
        root.right = new Tree(30);
        root.left.left = new Tree(40);
        root.left.right = new Tree(60);
        String data = serializeDeserializeTree.serialize(root, new ArrayList<>());
        System.out.println(data);
        Tree node = serializeDeserializeTree.deSerialize(data);
        printInorderTraversal(node);
    }

    private static void printInorderTraversal(Tree node) {
        if (node==null) return;
        printInorderTraversal(node.left);
        System.out.print(node.data+" ");
        printInorderTraversal(node.right);
    }
}
