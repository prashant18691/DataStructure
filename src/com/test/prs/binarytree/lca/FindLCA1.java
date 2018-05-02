package com.test.prs.binarytree.lca;

import java.util.ArrayList;
import java.util.List;
//O(n) time + extra space for path list
//total 3 traversals
public class FindLCA1 {
    static Node root;
    static List<Integer> path1 = new ArrayList<>();
    static List<Integer> path2 =new ArrayList<>();
    public static int findLCAUtil(int a, int b){
        path1.clear();
        path2.clear();
        return findLCA(root,a,b);
    }
    private static int findLCA(Node node, int a, int b){
        if(!findPath(root,a,path1) || !findPath(root,b,path2))
            return -1;
        int i;
        for (i = 0; i < path1.size() && i< path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i-1);
    }

    private static boolean findPath(Node node, int n, List<Integer> path) {
        if (node==null) return false;
        path.add(node.data);
        if (node.data==n) return true;
        if (node.left!=null && findPath(node.left,n,path))
            return true;
        if (node.right!=null && findPath(node.right,n,path))
            return true;
        path.remove(path.size()-1);
        return false;
    }

    public static void main(String[] args) {
        FindLCA1 tree = new FindLCA1();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("LCA(4, 5): " + tree.findLCAUtil(4,5));
        System.out.println("LCA(4, 6): " + tree.findLCAUtil(4,6));
        System.out.println("LCA(3, 4): " + tree.findLCAUtil(3,4));
        System.out.println("LCA(2, 4): " + tree.findLCAUtil(2,4));
    }

}
