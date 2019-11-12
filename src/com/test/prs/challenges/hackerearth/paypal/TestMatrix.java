package com.test.prs.challenges.hackerearth.paypal;

import java.util.Scanner;


public class TestMatrix {
    public static void main(String args[] ) throws Exception {
        Scanner br = new Scanner(System.in);
        int n = Integer.valueOf(br.next());
        int m = Integer.valueOf(br.next());
        String grid[][] = new String[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
                grid[grid_i] = br.next().split("");
        }
        int  q  = Integer.valueOf(br.next());
        int res = 0;
        for (int i = 0; i < q; i++) {
            res += findUniqueSquares(grid, Integer.valueOf(br.next()));
            System.out.println(res);
        }

    }

    private static int findUniqueSquares(final String[][] grid, int k) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n-k+1; i++)
        {
            for (int j = 0; j < m-k+1; j++)
            {

                // Calculate and print sum of
                // current sub-square
                int sum = 0;
                for (int p = i; p < k+i; p++)
                    for (int q = j; q < k+j; q++)
//                        sum += grid[p][q];

                System.out.print(sum+ " ");
            }

            // Line separator for sub-squares
            // starting with next row
            System.out.println();
        }
        return count;
    }
}
