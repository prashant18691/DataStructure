package com.test.prs.matrix.sudokuValidator;

import java.util.Arrays;
import java.util.Scanner;

public class TestSudoku {

    public boolean validateSudoku1(String[][] sudoku){
        for(int i=0;i<sudoku.length;i++){
            String[] row = sudoku[i].clone();
            String[] col = new String[sudoku.length];
            String[] square = new String[sudoku.length];
            for(int j=0;j<sudoku.length;j++){
                col[j] = sudoku[j][i];
                square[j] = sudoku[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if(!(checkSudoku(row) &&  checkSudoku(col) && checkSudoku(square)))
                return false;
        }
        return true;
    }

    private boolean checkSudoku(String[] in) {
        Arrays.sort(in);
        int count=0;
        for(String i : in)
            if(Integer.parseInt(i)!=++count)
                return false;
        return true;
    }

    public static void main(String[] args){
        TestSudoku test = new TestSudoku();
     /*   int[][] sMatrix={
                {5,3,4,6,7,8,9,1,2},
                {6,7,2,1,9,5,3,4,8},
                {1,9,8,3,4,2,5,6,7},
                {8,5,9,7,6,1,4,2,3},
                {4,2,6,8,5,3,7,9,1},
                {7,1,3,9,2,4,8,5,6},
                {9,6,1,5,3,7,2,8,4},
                {2,8,7,4,1,9,6,3,5},
                {3,4,5,2,8,6,1,7,9}
        };*/

        Scanner s = new Scanner(System.in);
        String[][] input = new String[9][9];
        for(int i=0;i<9;i++){
            input[i] = s.nextLine().split(" ");
        }
        boolean isValid = test.validateSudoku1(input);
        if(isValid)
            System.out.println("Correct");
        else
            System.out.println("Incorrect");
    }
}
