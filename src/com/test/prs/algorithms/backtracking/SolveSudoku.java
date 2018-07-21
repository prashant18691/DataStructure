package com.test.prs.algorithms.backtracking;

public class SolveSudoku {
    private int[][] sudoku = new int[9][9];
    private int MIN = 1;
    private int MAX = 9;
    public SolveSudoku(int[][] sudoku){
         this.sudoku = sudoku;
    }

    public void solve(){
        if (findSolution(0, 0))
            printSolution();
        else {
            System.out.println("No Solution");
        }
    }

    private boolean findSolution(int rowIndex,  int columnIndex) { // column-wise solution 1st col 2nd col....
        if (rowIndex == 9 && ++columnIndex == 9) // completed ?
            return true;
        if (rowIndex==9){ // hop to next column
            rowIndex = 0;
        }
        if (sudoku[rowIndex][columnIndex]!=0) // skip filled cells and move to next row
            return findSolution(rowIndex+1,columnIndex); //
        for (int num = MIN; num <= MAX ; num++) {
            if (isValid(rowIndex,columnIndex,num)){
                sudoku[rowIndex][columnIndex] = num;
                if (findSolution(rowIndex+1,columnIndex))
                    return true;
                sudoku[rowIndex][columnIndex] = 0; //backtrack
            }
        }
        return false;
    }

    private boolean isValid(int rowIndex, int columnIndex, int num) {
        for (int col = 0; col < 9; col++) {// check if row contains the same number
            if (sudoku[rowIndex][col]==num)
                return false;
        }
        for (int row = 0; row < 9; row++) {//  check if col contains the same number
            if (sudoku[row][columnIndex]==num)
                return false;
        }
        int rowOffset = rowIndex-rowIndex%3;
        int colOffset = columnIndex-columnIndex%3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (sudoku[r+rowOffset][c+colOffset]==num)
                    return false;
            }
        }
    return true;
    }

    private void printSolution() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println(" ");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

            int sudokuTable[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                    {5, 2, 0, 0, 0, 0, 0, 0, 0},
                    {0, 8, 7, 0, 0, 0, 0, 3, 1},
                    {0, 0, 3, 0, 1, 0, 0, 8, 0},
                    {9, 0, 0, 8, 6, 3, 0, 0, 5},
                    {0, 5, 0, 0, 9, 0, 6, 0, 0},
                    {1, 3, 0, 0, 0, 0, 2, 5, 0},
                    {0, 0, 0, 0, 0, 0, 0, 7, 4},
                    {0, 0, 5, 2, 0, 6, 3, 0, 0}};
            SolveSudoku solveSudoku = new SolveSudoku(sudokuTable);
            solveSudoku.solve();
    }
}
