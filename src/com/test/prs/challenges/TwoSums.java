package com.test.prs.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSums {

    static void solve(int[] arr, int money) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(money-arr[i])){
                System.out.println(map.get(money-arr[i]) + " "+(i+1));
            break;
            }
            else
             map.put(arr[i],i+1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int money = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            solve(arr, money);
        }
        in.close();
    }
}

