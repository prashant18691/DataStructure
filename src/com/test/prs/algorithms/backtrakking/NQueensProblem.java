package com.test.prs.algorithms.backtrakking;

public class NQueensProblem {
    private int noOfQueens;
    private int[][] chessTable;

    public NQueensProblem(int noOfQueens){
        this.chessTable = new int[noOfQueens][noOfQueens];
        this.noOfQueens = noOfQueens;
    }

    public static void main(String[] args) {
        NQueensProblem problem  =  new NQueensProblem(3);
        problem.solve();
    }

    public void solve(){
        if (isSolvable(0))
            printChessTable();
        else {
            System.out.println("No Solutions");
        }
    }

    private boolean isSolvable(int col) {
        if (col == noOfQueens)
            return true;

        for (int i = 0; i < noOfQueens; i++) {// row tracking
            if (isValid(i,col)){
                chessTable[i][col] = 1;

                if (isSolvable(col+1))
                    return true;
                chessTable[i][col] = 0; // Backtrackking; similar to DFS
            }
        }
        return false;
    }

    private boolean isValid(final int row, final int col) {
        for (int i = 0; i < col; i++) {
            if (chessTable[row][i]==1)
                return false;
        }
        for (int i = row, j = col; i >=0 && j>=0 ; i--,j--) {
            if (chessTable[i][j]==1)
                return false;
        }
        for (int i = row,j=col; i < noOfQueens && j>= 0 ; i++,j--) {
            if (chessTable[i][j]==1)
                return false;
        }
        return true;
    }

    private void printChessTable() {
        for (int i = 0; i < noOfQueens; i++) {
            for (int j = 0; j < noOfQueens; j++) {
                if (chessTable[i][j] == 1)
                    System.out.print(" * ");
                else {
                    System.out.print(" - ");
                }

            }
            System.out.println();
        }
    }
}
