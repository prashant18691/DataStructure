package com.test.prs.string;

import java.util.HashMap;
import java.util.Map;


public class FirstNonRepeatingCharacter {
    class Details{
         int count;
         int index;

        Details(final int index) {
            this.count = 1;
            this.index = index;
        }
    }
    public static final int MAX_CHARS = 256;
    public char method1(String str){ //O(n); 2  traversal on string length
        int[] charCount = new int[MAX_CHARS];
        for (int i = 0; i < str.length(); i++) {
            charCount[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (charCount[str.charAt(i)]==1)
                return str.charAt(i);
        }
        return '0';
    }

    public  int method2(String str){
        Map<Character, Details> countMap = getCountMap(str);
        for (int i = 0; i < str.length(); i++) {
            if (countMap.get(str.charAt(i)).count == 1){
                return countMap.get(str.charAt(i)).index;
            }
        }
        return -1;
    }

    public Map<Character, Details> getCountMap(final String str) {
        Map<Character, Details> countMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (countMap.containsKey(str.charAt(i))){
                countMap.get(str.charAt(i)).count++;
            }
            else {
                countMap.put(str.charAt(i), new Details(i));
            }
        }
        return countMap;
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacter f = new FirstNonRepeatingCharacter();
        String str = "geeksforgeeks";
//        System.out.println(f.method1(str));
        int result = f.method2(str);
        if (result == -1) {
            System.out.println("String empty or all characters are repeating");
        }
        else{
            System.out.println(str.charAt(result));
        }
    }
}
