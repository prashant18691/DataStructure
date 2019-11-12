package com.test.prs.algorithms.backtracking;

public class HamiltonionCycle {
    private int[][] matrix;
    private int[] hamiltonionPath;
    private int noOfVertices;

    public HamiltonionCycle(int[][] matrix) {
        this.matrix = matrix;
        this.noOfVertices = matrix.length;
        hamiltonionPath = new int[noOfVertices];
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1},
            {1, 0, 1},
            {1, 1, 0}};
        HamiltonionCycle cycle = new HamiltonionCycle(matrix);
        cycle.findHamiltonionPath();
    }

    public void findHamiltonionPath() {
        hamiltonionPath[0] = 0;
        if (isSolvable(1)) {
            printHamiltonionPath();
        } else {
            System.out.println("No Solution....");
        }
    }

    private boolean isSolvable(final int hamiltonIndex) {
        if (hamiltonIndex == noOfVertices){
            if (matrix[hamiltonionPath[hamiltonIndex-1]][hamiltonionPath[0]]==1)
                return true;
            else
                return false;
        }

        for (int vertex = 1; vertex < noOfVertices; vertex++) {// to find which vertex is the next hamilton vertex
            if(isValid(hamiltonIndex,vertex))
                hamiltonionPath[hamiltonIndex] = vertex;
            if (isSolvable(hamiltonIndex+1))
                return true;
            //Backtrack
        }
        return false;
    }

    private boolean isValid(int currHamiltonIndex, int vertex) {
        if (matrix[hamiltonionPath[currHamiltonIndex-1]][vertex]==0)// check path exists/neighbours
            return false;
        for (int j = 0; j < currHamiltonIndex; j++) {
            if (hamiltonionPath[j]==vertex)  // check if hamiltonion vertex is already set
                return false;
        }
        return true;
    }

    private void printHamiltonionPath() {
        System.out.println("Hamiltonion Cycle");
        for (int i = 0; i < hamiltonionPath.length; i++) {
            System.out.print(hamiltonionPath[i]+" ");
        }
        System.out.print(hamiltonionPath[0]);
    }
}
