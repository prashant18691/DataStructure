package com.test.test;

import java.util.LinkedList;

class Solution1 {
    public int deepestLeavesSum1(TreeNode root) {
        if(root==null) return 0;
        int height = getHeight(root);
        return solve(root,height);
    }

    int solve(TreeNode root, int h){
        if(root==null) return 0;
        if(h==1) return root.val;
        return solve(root.right,h-1) + solve(root.left,h-1);
    }

    int getHeight(TreeNode node){
        if(node==null) return 0;
        return 1+Math.max(getHeight(node.left),getHeight(node.right));
    }

    public int deepestLeavesSum(TreeNode root) {
        int res = 0, i;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            for (i = q.size() - 1, res = 0; i >= 0; --i) {
                TreeNode node = q.poll();
                res += node.val;
                if (node.right != null) q.add(node.right);
                if (node.left  != null) q.add(node.left);
            }
        }
        return res;
    }

}
