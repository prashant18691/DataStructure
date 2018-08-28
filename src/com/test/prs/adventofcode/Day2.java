package com.test.prs.adventofcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


public class Day2 {
    public int solve(int[][] input){
        int checkSum = 0;
        for (int i = 0; i < input.length; i++) {
            checkSum+=findDiffOfMaxMin(input[i]);
        }
        return checkSum;
    }

    private int findDiffOfMaxMin(int[] row) {
        int max = row[0];
        int min = row[0];
        for (int i = 1; i < row.length; i++) {
            if (row[i]>max)
                max = row[i];
            if (row[i]<min)
                min = row[i];
        }
        return max-min;
    }

    public static void main(String[] args) {
        Day2 day2 = new Day2();
        InputStream inputFile = day2.getInputFile();
        Scanner s = null;
        s = new Scanner(inputFile);
        int[][] input = new int[16][16];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                input[i][j] = s.nextInt();
            }
        }
        System.out.println(day2.solve(input));
    }

    public InputStream getInputFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResourceAsStream("C:\\Users\\pupadhya\\Documents\\Personal\\DataStructure\\src\\com"
                + "\\test\\prs\\adventofcode\\input.txt");
    }
}
