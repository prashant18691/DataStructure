package com.test.prs.algorithms.dynamicprogramming;

public class KnapsackProblem {
    private int numOfItems;
    private int capacity;
    private int[] weights;
    private int[] value;
    private int[][] knapsackTable;

    public KnapsackProblem(int numOfItems, int capacity, int[] weights, int[] value){
        this.numOfItems = numOfItems;
        this.capacity = capacity;
        this.weights = weights;
        this.value = value;
        knapsackTable = new int[numOfItems+1][capacity+1];
    }

    public void solve(){
        for (int i = 1; i < numOfItems + 1; i++) {
            for (int w = 1; w < capacity + 1; w++) {
                int notTakingItem = knapsackTable[i-1][w];
                int takingItem = 0;
                if (weights[i]<=w){
                    takingItem = value[i] + knapsackTable[i-1][w-weights[i]]; // take current item and get remaining
                    // value if available from the previous item
                }
                knapsackTable[i][w] = Math.max(notTakingItem, takingItem);
            }
        }
        System.out.println(knapsackTable[numOfItems][capacity]);
        result();
    }

    public void result(){
        for (int n = numOfItems, w = capacity; n > 0 ; n--) {
            if (knapsackTable[n][w] != 0 && knapsackTable[n][w] != knapsackTable[n - 1][w]) {
                System.out.println("took item # "+ n);
                w = w-weights[n];
            }
        }
    }

    public static void main(String[] args) {
        int numOfItems = 3;
        int capacityOfKnapsack = 5;

        int[] weightOfItems = new int[numOfItems + 1];
        weightOfItems[1] = 4;
        weightOfItems[2] = 2;
        weightOfItems[3] = 3;

        int[] profitOfItems = new int[numOfItems + 1];
        profitOfItems[1] = 10;
        profitOfItems[2] = 4;
        profitOfItems[3] = 7;

        KnapsackProblem knapsackProblem = new KnapsackProblem(numOfItems,capacityOfKnapsack,weightOfItems,profitOfItems);
        knapsackProblem.solve();
    }
}
