package com.test.test;

import java.util.LinkedList;
public class TestMaxTree{
    public static void main(String[] args) {
        MaxTree t = new MaxTree();
        TreeNode root = t.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        printInorder(root);
    }

    private static void printInorder(TreeNode root) {
        if (root==null) return;
        printInorder(root.left);
        System.out.print(root.val+" ");
        printInorder(root.right);
    }
}
 class MaxTree {

        public TreeNode constructMaximumBinaryTree1(int[] nums) {
            LinkedList<TreeNode> list = new LinkedList<>();
            TreeNode curr = null;
            for(int i:nums){
                curr = new TreeNode(i);
                while(!list.isEmpty() && list.peekFirst().val<curr.val)
                    curr.left = list.removeFirst();
                if(!list.isEmpty())
                    list.peekFirst().right=curr;
                list.addFirst(curr);
            }
            return list.peekLast();
        }

     public TreeNode constructMaximumBinaryTree(int[] nums) {
         return solve(nums,0,nums.length-1);
     }

     public TreeNode solve(int[] nums, int l, int h){
         if(l>h) return null;
         int max = findMax(nums,l,h);
         TreeNode root = new TreeNode(nums[max]);
         root.left = solve(nums,l,max-1);
         root.right = solve(nums,max+1,h);
         return root;
     }

     public int findMax(int[] nums, int l, int h){
         int max = l;
         for(int i=l;i<=h;i++){
             if(nums[i]>nums[max])
                 max=i;
         }
         return max;
     }
}
