package com.test.prs.string;

import java.util.*;

public class FindSmallestWindow {

    static final int MAX_CHAR = 256;
    public static void findWindow(String str , String pat){
        List<String> substringList = getSubstring(str);
        List<String> possibleAns =  new ArrayList<>();
        for(String eachStr : substringList){
            String s = new String(eachStr);
            for(char i : pat.toCharArray()) {
                if (!s.contains(String.valueOf(i))) {
                    possibleAns.remove(eachStr);
                    break;
                }
                    if(!possibleAns.contains(eachStr))
                    possibleAns.add(s);
                    s=s.replaceFirst(String.valueOf(i),"");
            }

        }
        Collections.sort(possibleAns, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        System.out.println("Possible Windows "+Arrays.toString(possibleAns.toArray()));
        System.out.println("Smallest Window "+possibleAns.get(0));
    }

    public static  List<String> getSubstring(String s){
        int length = s.length();
        List<String> substringList = new ArrayList<>();
        for(int i=0; i<length;i++){
            StringBuilder c = new StringBuilder();
            c.append(s.charAt(i));
            for(int j=i+1; j<=length;j++){
                substringList.add(c.toString());
                if(j<length)
                    c.append(s.charAt(j));
            }
        }
        return substringList;
    }

    public static String findWindow1(String text, String pat){// efficient
        int n = text.length();
        int m = pat.length();

        if(n<m){
            System.out.println("No pattern found");
            return "";
        }
        int[] hash_text = new int[MAX_CHAR];
        int[] hash_pat = new int[MAX_CHAR];
        for(int i=0;i<m;i++)
            hash_pat[pat.charAt(i)]++;

        int count = 0, start = 0, start_index = -1, min_length = Integer.MAX_VALUE;
        for (int j=0;j<text.length();j++){//geeksforgeeks
            hash_text[text.charAt(j)]++; // increment for each character in text
            if(hash_text[text.charAt(j)]<=hash_pat[text.charAt(j)])// meet min requirement
                count++;
            if(count==m){
                while(hash_text[text.charAt(start)]>hash_pat[text.charAt(start)])// remove unwanted character from the window
                    hash_text[text.charAt(start++)]--;// THIS IS A TEST STRING TIST
                int window_length = j - start + 1;
                if(min_length>window_length){
                    min_length = window_length;
                    start_index = start;
                }
          //      System.out.println(text.substring(start_index,start_index+min_length)+" "+text.charAt(j));
            }
        }
        if(start_index==-1) {
            System.out.println("No window exists");
            return "";
        }
        return text.substring(start_index,start_index+min_length);
    }

    public static void main(String[] args) {
        System.out.println(findWindow1("THIS IS A TEST STRING","TIST"));
    }

}
