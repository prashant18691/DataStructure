package com.test.prs.matrix;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BFS_Graph {

    static Node[][] grid;

    static class Node{
        char data;
        int x,y,distance;
        boolean isVisited;

        Node(final char data, final int x, final int y, final int distance) {
            this.data = data;
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    // Complete the minimumMoves function below.
    static int minimumMoves(int startX, int startY, int goalX, int goalY)     {
        Queue<Node> queue = new LinkedList<>();
        grid[startX][startY].distance = 0;
        grid[startX][startY].isVisited = true;
        queue.add(grid[startX][startY]);

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.x==goalX && node.y==goalY) return node.distance;

            for (int i = node.x+1; i < grid.length; i++) {// going down
                if (!isValid(i,node.y) || grid[i][node.y].data=='X') break;
                if (!grid[i][node.y].isVisited){
                    grid[i][node.y].isVisited = true;
                    grid[i][node.y].distance = node.distance+1;
                    queue.add(grid[i][node.y]);
                }
            }

            for (int i = node.x-1; i >=0 ; i--) { //going up
                if (!isValid(i,node.y) || grid[i][node.y].data=='X') break;
                if (!grid[i][node.y].isVisited){
                    grid[i][node.y].isVisited = true;
                    grid[i][node.y].distance = node.distance+1;
                    queue.add(grid[i][node.y]);
                }
            }

            for (int i = node.y-1; i >= 0 ; i--) { //going left
                if (!isValid(node.x,i) || grid[node.x][i].data=='X') break;
                if (!grid[node.x][i].isVisited){
                    grid[node.x][i].isVisited = true;
                    grid[node.x][i].distance = node.distance+1;
                    queue.add(grid[node.x][i]);
                }
            }

            for (int i = node.y+1; i < grid.length ; i++) { //going right
                if (!isValid(node.x,i) || grid[node.x][i].data=='X') break;
                if (!grid[node.x][i].isVisited){
                    grid[node.x][i].isVisited = true;
                    grid[node.x][i].distance = node.distance+1;
                    queue.add(grid[node.x][i]);
                }
            }

        }


        return -1;
    }

    private static boolean isValid(final int x, final int y) {
        int n = grid.length;
        if (x<0 || y< 0 || x>=n || y>=n) return false;
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        grid = new Node[n][n];

        fillGrid(n, grid);

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(startX, startY, goalX, goalY);

        System.out.println(String.valueOf(result));
       /* bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }

    public static void fillGrid(final int n, final Node[][] grid) {
        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = new Node(gridItem.charAt(j),i,j,Integer.MAX_VALUE);
            }
        }
    }
}

