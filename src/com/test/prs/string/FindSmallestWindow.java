package com.test.prs.string;

import java.sql.Timestamp;
import java.util.*;

public class FindSmallestWindow {


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

    public static void main(String[] args) {
        findWindow("geeksforgeeks","ork");
    }

}
