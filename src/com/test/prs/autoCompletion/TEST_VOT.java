package com.test.prs.autoCompletion;

import java.util.*;

public class TEST_VOT {
    static Map<Integer,List<Integer>> map = new HashMap<>();

    static void getVOT(BinaryNode node,Integer i){
        if(node==null)
            return;
        List<Integer> list = map.get(i);
        if(list==null)
            map.put(i,list=new ArrayList<>());
        list.add(node.getData());
        getVOT(node.getLeft(),i-1);
        getVOT(node.getRight(),i+1);
    }

    public static void main(String[] args){

        BinaryNode root = new BinaryNode(1);
        BinaryNode left1 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(4);
        BinaryNode node4 = new BinaryNode(5);
        left1.setLeft(node3);
        left1.setRight(node4);
        BinaryNode right1 = new BinaryNode(3);
        BinaryNode node5 = new BinaryNode(6);
        BinaryNode node6 = new BinaryNode(7);
        right1.setLeft(node5);
        right1.setRight(node6);
        root.setLeft(left1);
        root.setRight(right1);

        getVOT(root,0);

        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            for(Integer i : entry.getValue())
                System.out.print(i);
            System.out.println();
        }
    }
}
