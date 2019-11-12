package com.test.prs.codeChef.challenge.AprilChallenge;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Node {

    private int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override public int hashCode() {
        return 1;
    }

    @Override public boolean equals(final Object obj) {
        Node node = (Node)obj;
        return node.x==this.x && node.y==this.y;
    }

    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int t = r.nextInt();
        for (int i = 0; i < t; i++) {
            int n = r.nextInt();
            int m = r.nextInt();
            Set<Node> nodeSet = new HashSet<>();
            int k = r.nextInt();
            for (int j = 0; j < k; j++) {
                nodeSet.add(new Node(r.nextInt(),r.nextInt()));
            }
            System.out.println(fence(nodeSet));
        }
    }

    private static int fence(Set<Node> nodeSet) {
        int min = 0;
        for (Node node : nodeSet){
            int cost = 4;
            if (nodeSet.contains(new Node(node.x-1,node.y)))
                cost--;
            if (nodeSet.contains(new Node(node.x+1,node.y)))
                cost--;
            if (nodeSet.contains(new Node(node.x,node.y-1)))
                cost--;
            if (nodeSet.contains(new Node(node.x,node.y+1)))
                cost--;
            min+=cost;
        }
        return min;
    }

}
