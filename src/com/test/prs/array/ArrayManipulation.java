package com.test.prs.array;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n+1];
        long max = 0, x = 0;
        for(int i=0; i<queries.length;i++){
            int p = queries[i][0];
            int q = queries[i][1];
            int k = queries[i][2];
            arr[p]+=k;
            arr[q+1]-=k;
        }
        for(int i=1;i<=n;i++){
            x+=arr[i];
            max = Math.max(x,max);
        }
        return max;
    }

    private static Scanner scanner = null;

    static {
        try {
            scanner = new Scanner(new File("C:\\Users\\pupadhya\\Downloads\\input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        System.out.println(arrayManipulation(n, queries));



        scanner.close();
    }
}

