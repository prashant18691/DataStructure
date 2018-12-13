package com.test.prs.algorithms.dynamicprogramming;

import java.io.IOException;
import java.util.Scanner;


public class FindSteps {

    /*
     * Complete the downToZero function below.
     */

    static int[] min = new int[1000001];
    static int downToZero(int n) {
        /*
         * Write your code here.
         */
        if(n<=3) return n;
        if(min[n]>0) return min[n];
        int minS = Integer.MAX_VALUE;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                int factor  = n/i;
                minS = Math.min(minS, downToZero(factor)+1);
            }
        }
        minS = Math.min(minS,1+downToZero(n-1));
        min[n] = minS;
        return minS;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = Integer.parseInt(scanner.nextLine().trim());

        int max = 1000001;
        int[] minSteps = new int[max];
        for(int i=0;i<max;i++) minSteps[i]=-1;
        minSteps[0]=0;minSteps[1]=1;minSteps[2]=2;minSteps[3] = 3;

        for(int i=2;i<max;i++){
            if(minSteps[i]==-1 || minSteps[i]>minSteps[i-1]+1)
                minSteps[i] = minSteps[i-1]+1;
            for(int j=1;j<=i && j*i<max;j++){
                if(minSteps[j*i]==-1 || minSteps[i*j]>minSteps[i]+1)
                    minSteps[j*i] = minSteps[i]+1;
            }
        }

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = minSteps[n];

            System.out.println(result);
            /*bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();*/
        }

//        bufferedWriter.close();
    }
}
