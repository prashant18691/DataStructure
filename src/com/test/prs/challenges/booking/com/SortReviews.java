package com.test.prs.challenges.booking.com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * Input
 breakfast beach citycenter location metro view staff price
 5
 1
 2
 1
 1
 2
 5
 This hotel has a nice view of the citycenter. The location is perfect.
 The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.
 Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
 They said I couldn't take my dog and there were other guests with dogs! That is not fair.
 Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.

 output
 2
 1


 */

public class SortReviews {

    /*
     * Complete the function below.
     */
    static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
        Map<Integer,Integer> m= new HashMap<>();
        for(int i : hotel_ids)
            m.putIfAbsent(i,0);
        List<String> keywordsArr = Arrays.asList(keywords.split(" "));
        for(int i=0;i<reviews.length;i++){
            String[] rev = reviews[i].split("\\W+");
            for (String s : rev){
                if(findIndex(keywordsArr,s)>-1)
                    m.put(hotel_ids[i],m.get(hotel_ids[i])+1);
            }
        }
        List<Map.Entry<Integer,Integer>> list =new ArrayList<Map.Entry<Integer,Integer>>(m.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

    static int findIndex(List<String> keywords, String text){
        return keywords.indexOf(text.toLowerCase());
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int[] res;
        String keywords;
        try {
            keywords = in.nextLine();
        } catch (Exception e) {
            keywords = null;
        }

        int hotel_ids_size = 0;
        hotel_ids_size = Integer.parseInt(in.nextLine().trim());

        int[] hotel_ids = new int[hotel_ids_size];
        for(int i = 0; i < hotel_ids_size; i++) {
            int hotel_ids_item;
            hotel_ids_item = Integer.parseInt(in.nextLine().trim());
            hotel_ids[i] = hotel_ids_item;
        }

        int reviews_size = 0;
        reviews_size = Integer.parseInt(in.nextLine().trim());

        String[] reviews = new String[reviews_size];
        for(int i = 0; i < reviews_size; i++) {
            String reviews_item;
            try {
                reviews_item = in.nextLine();
            } catch (Exception e) {
                reviews_item = null;
            }
            reviews[i] = reviews_item;
        }

        res = sort_hotels(keywords, hotel_ids, reviews);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}

