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
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
        right.right = new TreeNode(6);
        left.left.left = new TreeNode(7);
        right.right.right = new TreeNode(8);
        root.left = left;
        root.right = right;

        Solution1 solution = new Solution1();
        System.out.println(solution.deepestLeavesSum(root));
    }
}
