package com.test.prs.graph;

import java.util.Arrays;

//minimum spanning tree
public class MST {
     private int V,E;
     private Edge[] edges;

    public MST(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[e];
        for(int i=0;i<E;i++)
            edges[i] = new Edge();
    }


    private static class Edge implements Comparable<Edge>{
        int src,dest,weight;

        public Edge(){}

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }

    private static class Subset{
        int rank,parent;

        public Subset(int rank, int parent) {
            this.rank = rank;
            this.parent = parent;
        }
    }

    public void kruskalMST(){
        Edge[] result  = new Edge[V-1];
        Arrays.sort(edges);
        Subset[] subsets = new Subset[V];
        for(int i=0;i<V;i++){
            subsets[i] = new Subset(0,i);
        }
        int i = 0,e = 0;
        while(e<V-1){
            Edge nextEdge = new Edge();
            nextEdge = edges[i++];
            int x = find(subsets,nextEdge.src);
            int y = find(subsets,nextEdge.dest);
            if(x!=y){
                result[e++] = nextEdge;
                union(subsets,x,y);
            }
        }

        for(int k=0;k<e;k++)
            System.out.println(result[k].src+" --- "+result[k].dest+" "+result[k].weight);
    }

    private void union(Subset[] subsets, int x, int y) {
        if(subsets[x].rank>subsets[y].rank)
            subsets[y].parent = x;
        else if(subsets[x].rank<subsets[y].rank)
            subsets[x].parent = y;
        else
        {
            subsets[y].parent = x;
            subsets[x].rank++;
        }
    }

    private int find(Subset[] subsets, int i) {// find parent of node
        if(subsets[i].parent!=i)
            return find(subsets,subsets[i].parent);
        return subsets[i].parent;
    }

    public static void main(String[] args) {
        MST graph = new MST(9,14);

        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 4;

        graph.edges[1].src = 0;
        graph.edges[1].dest = 7;
        graph.edges[1].weight = 8;

        graph.edges[2].src = 1;
        graph.edges[2].dest = 2;
        graph.edges[2].weight = 8;

        graph.edges[3].src = 1;
        graph.edges[3].dest = 7;
        graph.edges[3].weight = 11;

        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 7;

        graph.edges[5].src = 7;
        graph.edges[5].dest = 8;
        graph.edges[5].weight = 7;

        graph.edges[6].src = 7;
        graph.edges[6].dest = 6;
        graph.edges[6].weight = 1;

        graph.edges[7].src = 8;
        graph.edges[7].dest = 6;
        graph.edges[7].weight = 6;

        graph.edges[8].src = 8;
        graph.edges[8].dest = 2;
        graph.edges[8].weight = 2;

        graph.edges[9].src = 2;
        graph.edges[9].dest = 5;
        graph.edges[9].weight = 4;

        graph.edges[10].src = 3;
        graph.edges[10].dest = 4;
        graph.edges[10].weight = 9;

        graph.edges[11].src = 3;
        graph.edges[11].dest = 5;
        graph.edges[11].weight = 14;

        graph.edges[12].src = 5;
        graph.edges[12].dest = 4;
        graph.edges[12].weight = 10;

        graph.edges[13].src = 6;
        graph.edges[13].dest = 5;
        graph.edges[13].weight = 2;

        graph.kruskalMST();
    }
}
