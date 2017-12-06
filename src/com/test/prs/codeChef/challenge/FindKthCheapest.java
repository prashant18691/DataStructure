package com.test.prs.codeChef.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindKthCheapest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] brands = new Integer[n];
        for(int brands_i = 0; brands_i < n; brands_i++){
            brands[brands_i] = in.nextInt();
        }
        Integer[] prices = new Integer[n];
        for(int prices_i = 0; prices_i < n; prices_i++){
            prices[prices_i] = in.nextInt();
        }
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int d = in.nextInt();// no. of brands shopper buys from
            Integer[] cameras = new Integer[d];// brands to buy from
            for(int cameras_i = 0; cameras_i < d; cameras_i++){
                cameras[cameras_i] = in.nextInt();
            }
            int k = in.nextInt();
            solve(brands,prices,cameras,k);
        }

        in.close();
    }

    private static void solve(Integer[] brands, Integer[] prices, Integer[] cameras, int k) {
        boolean chosen = false;
        int length = cameras.length;
        List<List<Integer>> index = new ArrayList<>();
        for(int i=0;i<length;i++) {
            List<Integer> eachIndex = new ArrayList<Integer>();
            getIndex(eachIndex,cameras[i],brands);
            index.add(eachIndex);
        }
        Arrays.sort(prices);
        for(List<Integer> eachIndex : index) {
            for(Integer i:eachIndex) {
                if (i != -1) {
                    if (i + 1 == k) {
                        chosen = true;
                        System.out.println(prices[i]);
                        break;
                    }
                }
            }
        }

        if(!chosen)
            System.out.println(-1);
    }

    private static void getIndex(List<Integer> eachIndex, Integer b,Integer[] brands) {
        Integer[] tempBrands = Arrays.copyOf(brands,brands.length);
        for(Integer eachBrand:tempBrands){
            if(eachBrand.equals(b)){
                int i = Arrays.asList(tempBrands).indexOf(b);
                eachIndex.add(i);
                tempBrands[i]=-1;
            }
        }
    }
}
