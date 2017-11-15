package com.test.prs.codeChef.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TestCodeExpo {
    public static void main(String[] args) throws IOException {
        BufferedReader ip = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(ip.readLine());
        String[] output = new String[t];
       for(int j=0;j<t;j++){
            String input = ip.readLine();
            String [] inputArr = input.split(" ");
            int n = Integer.parseInt(inputArr[0]);
            int r = Integer.parseInt(inputArr[1]);
            int[] numArr = new int[n];
            input = ip.readLine();
            inputArr = input.split(" ");
            for(int i=0;i<n;i++)
                numArr[i]=Integer.parseInt(inputArr[i]);
            output[j]=checkValidity(numArr,n,r);
        }
        for(String s:output)
            System.out.println(s);
    }

    private static String checkValidity(int[] numArr, int n, int r) {
        int maxLeft = Integer.MAX_VALUE;
        int minRight = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int curr = numArr[i];
            if(curr>r){
                if(curr<maxLeft)
                    maxLeft=curr;
                else
                    return "NO";
            }
            else{
                if(curr>minRight)
                    minRight=curr;
                else
                    return "NO";
            }
        }
        return "YES";
    }
}
