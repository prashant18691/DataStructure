package com.test.test;


import java.util.ArrayList;

// Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // if(s==null && t==null) return true;
        String tStr = getNodesInorder(t);
        String sStr = getNodesInorder(s);
        return sStr.contains(tStr);
    }

    String getNodesInorder(TreeNode t){
        if(t==null) return "";
        String lNode = getNodesInorder(t.left);
        String rNode = getNodesInorder(t.right);
        return lNode+t.val+rNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(5);
        left.left = new TreeNode(1);
        left.right = new TreeNode(2);
        left.right.left = new TreeNode(0);
        root.left = left;
        root.right = right;

        TreeNode s = new TreeNode(4);
        s.left = new TreeNode(1);
        s.right = new TreeNode(2);

        Solution solution = new Solution();
        solution.isSubtree(root, s);
    }
}
