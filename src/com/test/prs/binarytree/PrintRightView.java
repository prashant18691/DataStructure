package com.test.prs.binarytree;

public class PrintRightView {
    Node root;
    class Max_Level{
        int max;
    }
    void printRightNodes(Node node, int level, Max_Level max_level){
        if (node==null) return;
        if (level>max_level.max){
            System.out.println(node.data);
            max_level.max = level;
        }
        if (node.right!=null)
            printRightNodes(node.right,level+1,max_level);
        else
            printRightNodes(node.left,level+1,max_level);
    }

    void printRightNodesUtil(){
        printRightNodes(root,1,new Max_Level());
    }

    public static void main(String[] args) {
        PrintRightView tree = new PrintRightView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.printRightNodesUtil();
    }
}
