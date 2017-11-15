package com.test.prs.sudokuValidator;

import java.util.Arrays;
import java.util.Scanner;

public class TestSudoku {

    public boolean validateSudoku(char[][] sudoku){
        for(int i=0;i<sudoku.length;i++){
            char[] row = sudoku[i].clone();
            char[] col = new char[sudoku.length];
            char[] square = new char[sudoku.length];
            for(int j=0;j<sudoku.length;j++){
                col[j] = sudoku[j][i];
                square[j] = sudoku[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if(!(checkSudoku(row) &&  checkSudoku(col) && checkSudoku(square)))
                return false;
        }
        return true;
    }

    public boolean validateSudoku1(char[][] sudoku){
        for(int i=0;i<sudoku.length;i++){
            char[] row = sudoku[i].clone();
            char[] col = new char[sudoku.length];
            char[] square = new char[sudoku.length];
            for(int j=0;j<sudoku.length;j++){
                col[j] = sudoku[j][i];
                square[j] = sudoku[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if(!(checkSudoku(row) &&  checkSudoku(col) && checkSudoku(square)))
                return false;
        }
        return true;
    }

    private boolean checkSudoku(char[] in) {
        Arrays.sort(in);
        int count=0;
        for(char i : in)
            if(Character.getNumericValue(i)!=++count)
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
        char[][] input = new char[9][9];
        for(int i=0;i<9;i++){
            String row = s.nextLine();
            if(row.isEmpty()){
                System.out.println("Incorrect");
                return;
            }

            try{
                Integer.parseInt(row);
            }
            catch(Exception ex){
                System.out.println("Incorrect");
                return;
            }
            char[] charArray = row.toCharArray();
            if(charArray!=null && charArray.length!=9) {
                System.out.println("Incorrect");
                return;
            }
            input[i]=charArray;
        }
        boolean isValid = test.validateSudoku(input);
        if(isValid)
            System.out.println("Correct");
        else
            System.out.println("Incorrect");
    }
}
