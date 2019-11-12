package com.test.prs.algorithms.backtracking;

public class ColoringProblem {
    private int numOfvertex;
    private int numOfcolors;
    private int[] colors;
    private int[][] matrix;

    public ColoringProblem(int[][] matrix, int numOfcolors){
        this.matrix = matrix;
        this.numOfvertex = matrix.length;
        this.numOfcolors = numOfcolors;
        this.colors = new int[numOfvertex];
    }

    public void find(){
        if (solve(0))
            showSolution();
        else {
            System.out.println("No Solution");
        }
    }

    private boolean solve(final int nodeIndex) {
        if (nodeIndex == numOfvertex)
            return true;
        for (int colorIndex = 1; colorIndex <= numOfcolors; colorIndex++) {
            if (isValidColor(nodeIndex,colorIndex)){
                colors[nodeIndex] = colorIndex;
                if (solve(nodeIndex+1))
                    return true;
                //Backtrack i.e. check with next color
            }
        }
        return false;
    }

    private boolean isValidColor(final int nodeIndex, final int colorIndex) {
        for (int i = 0; i < numOfvertex; i++) {
            if (matrix[nodeIndex][i] == 1 && colors[i]==colorIndex)// check path exists
                // and neighbouring nodes are of color other than colorIndex
                return false;
        }
        return true;
    }

    private void showSolution() {
        for (int i = 0; i < numOfvertex; i++) {
            System.out.println("Node "+(i+1)+" has color "+colors[i]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1},
                          {1,0,1,0},
                          {1,1,0,1},
                          {1,0,1,0}};
        int numOfColors = 3;
        ColoringProblem problem = new ColoringProblem(matrix,numOfColors);
        problem.find();
    }
}
