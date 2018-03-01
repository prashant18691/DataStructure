package com.test.prs.string.urlshortner;

public class UrlShortner {
    private static final char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    public static String IdToShortUrl(int id){
        StringBuffer sb = new StringBuffer("");
        while (id>0){
            sb.append(map[id%62]);
            id/=62;
        }
        return sb.toString();
    }

    public static int shortUrlToId(String url){
        int id = 0;
        if (url==null)
            return 0;
        if (url.isEmpty())
            return 0;
        for (int i = url.length()-1; i >=0 ; i--) {
            char c = url.charAt(i);
            if (c>='a' && c<='z')
                id = id*62+c-'a';
            if (c>='A' && c<='Z')
                id = id*62+c-'A'+26;
            if (c>='0' && c<='9')
                id = id*62+c-'0'+52;
        }
        return id;
    }

    public static void main(String[] args) {
        int id = 5534554;
        String shortURL = UrlShortner.IdToShortUrl(id);
        System.out.println(shortURL);
        System.out.println(UrlShortner.shortUrlToId("aaXnx"));

    }
}
