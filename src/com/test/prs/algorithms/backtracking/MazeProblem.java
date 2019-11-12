package com.test.prs.algorithms.backtracking;

public class MazeProblem {
    private int[][] maze;
    private int[][] solution;
    private int MAZE_SIZE;
    public MazeProblem(int[][] maze){
        this.maze = maze;
        this.MAZE_SIZE = maze.length;
        this.solution = new int[MAZE_SIZE][MAZE_SIZE];
    }

    public  void solve(){
        if (findPath(0, 0))
            printPath();
        else {
            System.out.println("No Solution");
        }
    }

    private boolean findPath(final int x, final int y) {
        if (isCompleted(x,y))
            return true;

        if (isValid(x,y)){
            solution[x][y] = 1;

            if (findPath(x+1,y))// //go bottom
                return true;

            if (findPath(x, y+1)) //go right
                return true;

            solution[x][y] = 0; //backtrack
        }

        return false;
    }

    private boolean isCompleted(final int x, final int y) {
        if (x==MAZE_SIZE-1 && y==MAZE_SIZE-1){
            solution[x][y] = 1;
            return true;
        }
        return false;
    }

    private boolean isValid(final int x, final int y) {
        if (x<0 || x>=MAZE_SIZE) return false;
        if (y<0 || y>=MAZE_SIZE) return false;
        if (maze[x][y] != 1) return false; // check if path exists
        return true;
    }

    private void printPath() {
        for (int i = 0; i < MAZE_SIZE; i++) {
            for (int j = 0; j < MAZE_SIZE; j++) {
                if (solution[i][j] == 1)
                    System.out.print(" S ");
                else
                    System.out.print(" - ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int mazeTable[][] = { { 1, 1, 1, 1 ,1},
                              { 1, 0, 0, 1, 0},
                              { 0, 0, 0, 1, 0},
                              { 1, 1, 1, 1, 1},
                              { 1, 1, 1, 0, 1}
        };
        MazeProblem problem = new MazeProblem(mazeTable);
        problem.solve();
    }
}
