package com.test.prs.matrix.sudokuValidator;

public class SudokuSolver {
    private static final int UNASSIGNED = 0;

    private static class Cell{
        int row;int col;

    }

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        if(solveSudoku(grid))
            printGrid(grid);
        else
            System.out.println("Unsolvable");

    }

    private static void printGrid(int[][] grid) {
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }

    public static boolean solveSudoku(int[][] grid) {
        Cell cell = new Cell();
        if (!checkAssignment(grid, cell)) return true;
        int row = cell.row;
        int col = cell.col;
        for(int num=1;num<=9;num++){
            if(isSafe(grid,row,col,num)){
                grid[row][col] = num;
                if(solveSudoku(grid))
                    return true;
                grid[row][col] = UNASSIGNED;        // backtracked
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] grid, int row, int col, int num) {
        return !usedInRow(grid,row,num) && !usedInCol(grid,col,num) && !usedInBox(grid,row-row%3,col-col%3,num);
    }

    private static boolean usedInBox(int[][] grid, int rowStart, int colStart, int num) {
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                if(grid[rowStart+r][colStart+c]==num)
                    return true;
            }
        }
        return false;
    }

    private static boolean usedInCol(int[][] grid, int col, int num) {
        for(int r=0;r<9;r++){
            if(grid[r][col]==num)
                return true;
        }
        return false;
    }

    private static boolean usedInRow(int[][] grid, int row, int num) {
        for(int c=0;c<9;c++){
            if(grid[row][c]==num)
                return true;
        }
        return false;
    }

    private static boolean checkAssignment(int[][] grid, Cell cell) {
        for(int r = cell.row;r<9;r++){
            for(int c = cell.col;c<9;c++){
                if(grid[r][c]==UNASSIGNED) {
                    cell.row=r;
                    cell.col=c;
                    return true;
                }
            }
        }
        return false;
    }
}
