package com.test.prs.algorithms.dynamicprogramming;

public class CoinChange {

    int[] coins;
    int amount;

    public CoinChange(final int[] coins, final int amount) {
        this.coins = coins;
        this.amount = amount;
    }

    public void solve(){
        int[][] dpTable = new int[coins.length+1][amount+1];
        for (int c = 0; c < amount+1; c++) {
            dpTable[0][c] = 0;
        }
        for (int r = 0; r < coins.length+1; r++) {
            dpTable[r][0] = 1;
        }
        for (int i = 1; i < coins.length+1; i++) {// first i coins
            for (int j = 1; j < amount+1; j++) {
                if (coins[i-1]<=j){
                    dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-coins[i-1]];
                }
                else{
                    dpTable[i][j] = dpTable[i-1][j];
                }
            }
        }
        System.out.println("Total number of ways of making "+amount+" Rs  :: "+ dpTable[coins.length][amount]);
        for (int i = coins.length, j = amount ; i>0 ; i--) {
            if (dpTable[i][j]!=0 && dpTable[i][j]!=dpTable[i-1][j]){
                System.out.println("pick "+ coins[i-1]);
                j = j-coins[i-1];
            }
        }

        for (int i = 0; i < coins.length+1; i++) {
            for (int j = 0; j < amount+1; j++) {
                System.out.print(dpTable[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int amount = 4;
        CoinChange coinChange = new CoinChange(coins,amount);
        coinChange.solve();
    }
}
