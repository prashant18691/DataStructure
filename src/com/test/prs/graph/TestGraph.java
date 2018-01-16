package com.test.prs.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TestGraph {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
            int n = s.nextInt();
            int e = s.nextInt();
            Graph g = new Graph(n);
            for(int i=0;i<e;i++) {
                int x = s.nextInt() - 1;
                int y = s.nextInt() - 1;
                g.addEdge(x,y);
                g.addEdge(y,x);
            }
            g.bfs(s.nextInt()-1);
            t--;
        }
    }
}

class Graph{
    private LinkedList<Integer>[] list;
    private int V;
    public Graph(int v){
        V = v;
        list = new LinkedList[V];
        for(int i=0;i<V;i++)
            list[i] = new LinkedList<Integer>();
    }

    public void addEdge(int v, int w){
        list[v].add(w);
    }

    void bfs(int s){
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist,-1);
        dist[s]=0;
        visited[s] = true;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        while(queue.size()!=0){
            s = queue.poll();
            Iterator<Integer> i = list[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n]=true;
                    dist[n] = dist[s]+6;//7-1=6
                    queue.add(n);
                }
            }
        }
        for(int i : dist){
            if(i!=0)
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
