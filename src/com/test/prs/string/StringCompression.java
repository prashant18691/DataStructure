package com.test.prs.string;

public class StringCompression {
    public static void compress(String text){
        int count = 1;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < text.length()-1; i++) {
            if (text.charAt(i)==text.charAt(i+1))
                count++;
            else {
                if (count>1)
                sb.append(text.charAt(i)+""+count);
                else
                    sb.append(text.charAt(i));
                count = 1;
            }
        }
        if (count>1)
            sb.append(text.charAt(text.length()-1)+""+count);
        else
            sb.append(text.charAt(text.length()-1));
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        String text = "aaaaabbbbbccccccaadeeefff";
        compress(text);
    }
}
