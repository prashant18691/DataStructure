package com.test.prs.algorithms.backtracking;

public class KnightsTour {
    public int[] xMoves = {1, 2, 2, 1, -1, -2, -2, -1};
    public int[] yMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    public int BOARD_SIZE = 8;
    public int[][] solution;
    public KnightsTour(){
        solution = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                solution[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public void solve(int i, int j){
        solution[i][j] = 1;

        if (solution(2, i, j))
            printSolution();
        else {
            System.out.println("No Solution");
        }
    }

    private boolean solution(final int stepCount, final int x, final int y) {
        if (stepCount == BOARD_SIZE*BOARD_SIZE+1)
            return true;
        for (int i = 0; i < BOARD_SIZE; i++) {
            int xMove = x + xMoves[i];
            int yMove = y + yMoves[i];
            if(isAValidMove(xMove,yMove)){
                solution[xMove][yMove] = stepCount;
                if(solution(stepCount+1, xMove, yMove))
                    return true;
                solution[xMove][yMove] = Integer.MIN_VALUE; // backtrack
            }
        }
        return false;
    }

    private boolean isAValidMove(final int x, final int y) {
        if (x<0 || x>=BOARD_SIZE) return false;
        if (y<0 || y>=BOARD_SIZE) return false;
        if (solution[x][y]!=Integer.MIN_VALUE) return false;
        return true;
    }

    private void printSolution() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(solution[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        KnightsTour tour = new KnightsTour();
        tour.solve(3,3);
    }
}
