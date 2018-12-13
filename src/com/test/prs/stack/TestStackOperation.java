package com.test.prs.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TestStackOperation {


    static int getPrime(int nth){
        int i=2, count=0;
        while(count<nth){
            if (isPrime(i)) count++;
            i++;
        }
        return i-1;
    }

    static boolean isPrime(int n){
        if(n==2 || n==3) return true;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        List<Stack<Integer>> A = new ArrayList<>();
        List<Stack<Integer>> B = new ArrayList<>();

        for(int i=0;i<=q;i++){
            A.add(new Stack<>());
            B.add(new Stack<>());
        }

        Stack<Integer> stack = A.get(0);

        String[] numberItems = scanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            stack.push(numberItem);
        }

        Stack<Integer> stackA = null;
        Stack<Integer> stackB = null;

        for(int i=1;i<=q;i++){
            stack = A.get(i-1);

            while(!stack.isEmpty()){
                int plate = stack.pop();
                if(plate%getPrime(i)==0){
                    stackB = B.get(i);
                    stackB.push(plate);
                }
                else{
                    stackA = A.get(i);
                    stackA.push(plate);
                }
            }
        }

        for (int i = 0; i < B.size(); i++) {
            stackB = B.get(i);
            while (!stackB.isEmpty()) {
                System.out.println(String.valueOf(stackB.pop()));
            }
        }


        for (int i = 0; i < A.size(); i++) {
            stackA = A.get(i);
            while (!stackA.isEmpty()) {
                System.out.println(String.valueOf(stackA.pop()));
            }
        }

        System.out.println();
    }
}

