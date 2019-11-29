package com.test.prs.linkedlist;

public class SortedLinkedListToBST {

    public static void main(String[] args) {
        SortedLinkedListToBST sortedLinkedListToBST =  new SortedLinkedListToBST();
        ListNode head = new ListNode(-10);
        head.next=new ListNode(-3);
        head.next.next=new ListNode(0);
        head.next.next.next=new ListNode(5);
        head.next.next.next.next=new ListNode(9);
        sortedLinkedListToBST.sortedListToBST(head);
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        return convert(head,null);
    }

    public TreeNode convert(ListNode head, ListNode tail){
        if(head==tail) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=tail && fast.next!=tail){
            fast=fast.next.next;
            slow=slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left=convert(head,slow);
        root.right=convert(slow.next,tail);
        return root;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
