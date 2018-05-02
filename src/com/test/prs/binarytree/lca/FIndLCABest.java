package com.test.prs.binarytree.lca;
//O(n   )
public class FIndLCABest {
    Node root;
    static boolean v1,v2;
    public Node findLCAUtil(int a, int b){
         v1 = false;v2 =false;
        Node lca = findLCA(root, a, b);
        if (v1 && v2)
            return lca;
        return null;
    }

    private Node findLCA(Node node, int a, int b) {
        if (node==null) return null;
        if (node.data==a){
            v1 =true;
            return node;
        }
        if (node.data==b){
            v2 = true;
            return node;
        }
        Node left_lca = findLCA(node.left,a,b);
        Node right_lca = findLCA(node.right,a,b);
        if (left_lca!=null && right_lca!=null)
            return node;
        return (left_lca!=null)?left_lca:right_lca;
    }

    public static void main(String[] args) {
        FIndLCABest tree = new FIndLCABest();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = tree.findLCAUtil(4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");

        lca = tree.findLCAUtil(4, 10);
        if (lca != null)
            System.out.println("LCA(4, 10) = " + lca.data);
        else
            System.out.println("Keys are not present");
    }
}

