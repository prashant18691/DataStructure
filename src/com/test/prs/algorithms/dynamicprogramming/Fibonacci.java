package com.test.prs.algorithms.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;


public class Fibonacci {
    private Map<Integer, Integer> memoization;

    public Fibonacci(){
        memoization = new HashMap<>();
        memoization.put(1,0);
        memoization.put(2,1);
    }

    public Integer findFibonacciDP(Integer n){
        if (memoization.containsKey(n))
            return memoization.get(n);
        memoization.put(n-1,findFibonacciDP(n-1));
        memoization.put(n-2,findFibonacciDP(n-2));
        Integer calculated = memoization.get(n-1)+memoization.get(n-2);
        memoization.put(n, calculated);
        return calculated;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.findFibonacciDP(20));
    }
}
