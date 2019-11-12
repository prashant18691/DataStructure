package com.test.prs.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class KthNonRepeatingCharacter {

    public KthNonRepeatingCharacter(String str) {
        this.count = new int[256];
        this.index = new int[256];
        Arrays.fill(index, str.length());
    }

    class Details{
        int count;
        int index;

        Details(final int index) {
            this.count=1;
            this.index = index;
        }
    }
    public  int method1(String str, int k){
        Map<Character, KthNonRepeatingCharacter.Details> countMap = getCountMap(str);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (countMap.get(str.charAt(i)).count == 1){
                count++;
            }
            if (count==k)
                return i;
        }
        return -1;
    }

    public Map<Character, KthNonRepeatingCharacter.Details> getCountMap(final String str) {
        Map<Character, KthNonRepeatingCharacter.Details> countMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (countMap.containsKey(str.charAt(i))){
                countMap.get(str.charAt(i)).count++;
            }
            else {
                countMap.put(str.charAt(i), new KthNonRepeatingCharacter.Details(i));
            }
        }
        return countMap;
    }
    int[] count;
    int[] index;
    public int method2(String str, int k){
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
            if (count[str.charAt(i)]==1) {
                index[str.charAt(i)] = i;
            }
            else {
                index[str.charAt(i)] = str.length();
            }
        }
        Arrays.sort(index);
        return index[k-1];
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        KthNonRepeatingCharacter f = new KthNonRepeatingCharacter(str);
        int result = f.method2(str, 4);
        if (result == -1 || result==str.length()) {
            System.out.println("Empty String or no non repeating character");
        }
        else{
            System.out.println(str.charAt(result));
        }
    }
}
