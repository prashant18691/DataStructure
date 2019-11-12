package com.test.prs.array;

public class StockProfit {

    static void maximizeProfit(int[] arr) {
        if (arr == null) return;
        int n = arr.length;
        if (n == 1) return;
        int min = 0, max = 0;
        int i = 0;
        while (i < n - 1) {
            while (i < n - 1 && arr[i] >= arr[i + 1])// local minima
                i++;

            if (i == n - 1) break;
            min = i++;

            while (i < n && arr[i - 1] <= arr[i])// local maxima
                i++;

            max = i-1;
                System.out.println("buy on day " + min +" sell on day "+ max);
                System.out.println(arr[max]-arr[min]);

        }
    }

    public static void main(String[] args) {
//        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int price[] = {10, 9, 2, 3, 15,  4, 1, 11, 14, 8, 9,  100};
        maximizeProfit(price);
    }


}
