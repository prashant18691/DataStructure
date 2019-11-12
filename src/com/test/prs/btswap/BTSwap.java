package com.test.prs.btswap;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class BTSwap {

    private static Node root;

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        int depth = 1;
        root = new Node(1,depth);
        Node node = root;
        for(int i=0; i < indexes.length;i++){
            ++depth;
            insert(node,indexes[i][0]);
            insert(node,indexes[i][1]);
        }
        int[][] result = new int[queries.length][indexes.length*2+1];

        for (int k = 0; k < queries.length; k++) {
            Queue<Node> q = new LinkedList<>();
            q.add(node);
            while (!q.isEmpty()){
                Node n = q.poll();
                if (n.depth%queries[k]==0){
                    Node temp = n.left;
                    n.left = n.right;
                    n.right = temp;
                }
                if (n.left!=null)
                    q.add(n.left);
                if (n.right!=null)
                    q.add(n.right);
            }
            result[k] = getInorderTraversal(node,result[k]);
        }
        return result;
    }

    private static int[] getInorderTraversal(Node node, int[] in) {
        if (node==null) return null;
        Stack<Node> stack = new Stack<>();
        Node curr = node;
        int i = 0;
        while (curr!=null || stack.size()>0){
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.data!=-1)
                in[i++] = curr.data;
            curr = curr.right;
        }

        return in;
    }

    static void insert(Node node, int data){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node temp = queue.poll();

            if(temp.left==null){
                temp.left = new Node(data,temp.depth+1);
                break;
            }
            else {
                if (temp.left.data!=-1)
                    queue.add(temp.left);
            }

            if(temp.right==null){
                temp.right = new Node(data,temp.depth+1);
                break;
            }
            else {
                if (temp.right.data!=-1)
                    queue.add(temp.right);
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                if(result[resultRowItr][resultColumnItr]==0)
                    break;
                System.out.print(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    System.out.print(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();
    }
}

class Node {
    int data,depth;
    Node left,right;
    public Node(int data, int depth){
        this.data = data;
        this.depth = depth;
    }
}

