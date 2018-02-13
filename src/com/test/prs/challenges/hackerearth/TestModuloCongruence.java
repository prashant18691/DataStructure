package com.test.prs.challenges.hackerearth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestModuloCongruence {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        /*if(k==0) System.out.println(0);
        else if(n<=k) System.out.println(0);
        else{
            Map<Integer,Integer> map = new HashMap<>();
            for(int i=1;i<=n;i++){
                int rem = i%k;
                if(map.containsKey(rem))
                    map.put(rem,map.get(rem)+1);
                else
                    map.putIfAbsent(rem,1);
            }
            int count = 0;
            for(Map.Entry<Integer,Integer> entry : map.entrySet())
                if(entry.getValue()==2)
                    count++;
                else
                {
                    int j = entry.getValue();
                    count+=j*(j-1)/2;
                }
            System.out.println(count);
        }*/
        int d=n/k;
        int d1=n%k;
        long res=((long)k)*d*(d-1)/2+(((long)d1)*d);
        System.out.println(res);



    }
}
