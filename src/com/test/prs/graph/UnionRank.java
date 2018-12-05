package com.test.prs.graph;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class UnionRank {

    static class Graph{
        int[] rank;
        int[] parent;
        int n;

        Graph(int n){
            this.n = 2*n+1;
            rank = new int[this.n];
            parent = new int[this.n];

            for(int i=1;i<this.n;i++)
                parent[i]=i;
        }

        int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y){
            //union using rank
            /*int xRep = find(x);
            int yRep = find(y);

            if(xRep==yRep)
                return;

            int xRank = rank[xRep];
            int yRank = rank[yRep];

            if(xRank>yRank){
                parent[yRep] = xRep;
            }
            else if(xRank<yRank){
                parent[xRep] = yRep;
            }
            else{
                parent[xRep] = yRep;
                for (int i = 1; i < n; i++) {
                    if (parent[i]==xRep)
                        parent[i] = yRep;
                }
                rank[yRep]++;
            }*/
            //without rank
            parent[find(x)] = find(y);
        }
    }



    /*
     * Complete the componentsInGraph function below.
     */
    //wrong solution
    static int[] componentsInGraph(int[][] gb) {
        /*
         * Write your code here.
         */
        int n = gb.length;
        Graph graph = new Graph(n);
        for(int i=0;i<n;i++){
            graph.union(gb[i][0],gb[i][1]);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        List<Integer> list = Arrays.stream(graph.parent).boxed().collect(Collectors.toList());

        for(int item : graph.parent) {
            if(item != 0) {
                int frequency = Collections.frequency(list, item);
                min = Math.min(min, frequency);
                max = Math.max(max, frequency);
            }
        }

        return new int[]{min,max};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] SPACE = componentsInGraph(gb);

        for (int SPACEItr = 0; SPACEItr < SPACE.length; SPACEItr++) {
            System.out.print(String.valueOf(SPACE[SPACEItr]));

            if (SPACEItr != SPACE.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

    }

    private static int[] try1(int[][] gb){
        int[] parents = new int[30001];
        for (int i = 0; i < gb.length; i++) {
            int a = gb[i][0];
            int b = gb[i][1];
            if(parents[a] == 0) parents[a] = a;
            if(parents[b] == 0) parents[b] = a;

            //Disjoin set idea, keep updating the representative element of each set.
            if(parents[a] != 0 || parents[b] != 0){
                int low = Math.min(parents[a], parents[b]);
                int high = Math.max(parents[a], parents[b]);
                for(int k=0; k<parents.length; k++){
                    if(parents[k] == high)
                        parents[k] = low;
                }
            }
        }
        Integer[] newArray = new Integer[parents.length];
        int i = 0;
        for (int value : parents) {
            newArray[i++] = value;
        }

        List<Integer> ints = Arrays.asList(newArray);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int item : newArray) {
            if(item != 0) {
                int frequency = Collections.frequency(ints, item);
                min = Math.min(min, frequency);
                max = Math.max(max, frequency);
            }
        }
        return new int[]{min,max};
    }
}

