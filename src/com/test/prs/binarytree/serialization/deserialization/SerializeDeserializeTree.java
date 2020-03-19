package com.test.prs.binarytree.serialization.deserialization;

import java.util.ArrayList;

public class SerializeDeserializeTree {
    public String serialize(Tree root, ArrayList<Integer> aa) {
//add Code here.
        StringBuilder sb = new StringBuilder();
        serializeTree(root,sb);
        //  System.out.print(sb.toString());
        return sb.toString();
    }

    void serializeTree(Tree node, StringBuilder sb){
        if(node==null) return;
        sb.append(node.data);
        if(node.left!=null||node.right!=null)
            sb.append("*");//internal node
        else {
            sb.append("/");//leaf node
            return;
        }

        if(node.left!=null)
            serializeTree(node.left,sb);

        if(node.right!=null)
            serializeTree(node.right,sb);
    }

    public Tree deSerialize(String data) {
        return deserializeTree(data,new int[1]);
    }

    Tree deserializeTree(String data, int[] index){
        if(index[0]>=data.length() || data.charAt(index[0])=='/'){
            index[0]++;
            return null;
        }
        int num=0;
        while(Character.isDigit(data.charAt(index[0]))) {
            num = 10 * num + (data.charAt(index[0]++)-'0');
        }
        Tree root = new Tree(num);
        if(index[0]<data.length() && data.charAt(index[0])=='*'){
            index[0]++;
            root.left=deserializeTree(data,index);
            root.right=deserializeTree(data,index);
        }
        else
            index[0]++;
        return root;
    }
}


class Tree{
    int data;
    Tree left,right;
    Tree(int d){
        data=d;
        left=right=null;
    }
}