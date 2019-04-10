package com.test.prs.codejam.google;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class SavingUniverse {

    private static final int MAX_SEARCH_ENGINES=100;
    private static final int MAX_QUERIES=1000;

    private static int[][] table = new int[MAX_SEARCH_ENGINES][MAX_QUERIES];

    private static void setup(){
        for (int i = 0; i < MAX_SEARCH_ENGINES; i++) {
            for (int j = 0; j < MAX_QUERIES; j++) {
                table[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new FileReader("C:\\Users\\pupadhya\\Downloads\\A-large-practice.in"));
        PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\pupadhya\\Downloads\\A-large-practice"
                + ".out"));
        int t = Integer.parseInt(s.readLine());
        for (int testCase = 1; testCase <= t ; testCase++) {
            setup();
            int n = Integer.parseInt(s.readLine());
            String[] searchEngines = new String[n];
            for (int i = 0; i < n; i++) {
                searchEngines[i] = s.readLine();
            }
            int q = Integer.parseInt(s.readLine());
            String[] queries = new String[q];
            for (int i = 0; i < q; i++) {
                queries[i] = s.readLine();
            }
            if (n == 0 || q == 0) {
                writer.println("Case #"+testCase+": 0");
                continue;
            }
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                result = Integer.min(result, minSwitch(searchEngines,queries,i,0));
            }
            writer.println("Case #"+testCase+": "+result);
            System.out.println("Case #"+testCase+": "+result);
        }
        writer.flush();
        writer.close();
    }

    private static int minSwitch(final String[] searchEngines, final String[] queries, final int i, final int j) {
        if (j>=queries.length)
            return 0;
        if (table[i][j]<Integer.MAX_VALUE)
            return table[i][j];
        int temp = Integer.MAX_VALUE;
        if (searchEngines[i].equals(queries[j])){
            for (int k = 0; k < searchEngines.length; k++) {
                if (k!=i){
                    temp = Integer.min(temp,minSwitch(searchEngines,queries,k,j+1)+1);
                }
            }
        }
        else{
            temp = minSwitch(searchEngines,queries,i,j+1);
        }
        table[i][j]=temp;
        return table[i][j];
    }
}
