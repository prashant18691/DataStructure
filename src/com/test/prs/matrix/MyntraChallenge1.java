package com.test.prs.matrix;

import java.util.*;

public class MyntraChallenge1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[][] arr = new String[2][n];
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = s.next();
            }
        }
        solve(arr);
    }

    private static void solve(String[][] arr) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<2;i++){
            for(int j=0;j<arr[i].length;j++){
                Integer count = map.get(arr[i][j]);
                if(!map.containsKey(arr[i][j]))
                    map.put(arr[i][j],count=1);
               else {
                    count++;
                    map.put(arr[i][j],count);
                }
            }
        }
        int n = arr[0].length;
        String[][] out = new String[2][n];
        int c=0;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            String s = entry.getKey();
            Integer count = entry.getValue();
            rearrange(out, c, s, count);
            if(count%2!=0 && c<n-1){
                out[0][++c]=s;
            }
            if(c<n)
                c++;
        }
        System.out.println(Arrays.deepToString(out));
    }

    private static void rearrange(String[][] out, int c, String s, Integer count) {
        count/=2;
            for(int j=c;j<count+c;j++){
                out[0][j]=s;
                out[1][j]=s;
            }

    }
}
