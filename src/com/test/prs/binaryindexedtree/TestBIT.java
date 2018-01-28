package com.test.prs.binaryindexedtree;

import java.util.Arrays;
import java.util.Scanner;

public class TestBIT {
    int N; int[] bit;

    public TestBIT(int n) {
        N = n;
        this.bit = new int[N];
    }

    public void update(int x, int val){
        for(;x<=N;x+=x&(-x)){
            bit[x]+=val;
        }
    }

    public int query(int x){
        int sum = 0;
        for(;x>0;x-=x&(-x))
            sum+=bit[x];
        return sum;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TestBIT t = new TestBIT(s.nextInt()+1);
        int[] arr = new int[t.N];
        for(int i=1;i< t.N;i++)
            t.update(i,arr[i]=s.nextInt());
        System.out.println(Arrays.toString(arr));
        System.out.println(t.query(4));
        System.out.println(t.query(6));
        System.out.println(t.query(8));
    }
}
