package com.test.prs.string;

public class WindowContainingDistinctStringCharacters {
    public static final int MAX_CHARS = 256;

    public static String findWindow(String text){
        int distinctCount = 0;
        boolean[] visited = new boolean[MAX_CHARS];
        int n = text.length();
        for (int i = 0; i < n; i++) {
            if(!visited[text.charAt(i)]){
                visited[text.charAt(i)]=true;
                distinctCount++;
            }
        }
        int start=0,startIndex=-1,min_window = Integer.MAX_VALUE;
        int count = 0; int[] curr_count = new int[MAX_CHARS];
        for (int i = 0; i < n; i++) {
            curr_count[text.charAt(i)]++;
            if(curr_count[text.charAt(i)]==1)
                count++;
            if (count==distinctCount){
                while (curr_count[text.charAt(start)]>1)
                    curr_count[text.charAt(start++)]--;
                int len_window = i-start+1;
                if (len_window<min_window) {
                    min_window = len_window;
                    startIndex = start;
                }
            }
        }
        return text.substring(startIndex,startIndex+min_window);
    }

    public static void main(String[] args) {
        System.out.println(findWindow("AABBBCBBAC"));
    }
}
