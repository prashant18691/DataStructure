package com.test.prs.gcd;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class FindGCDEfficient {
    InputStream is;
    PrintWriter out;
    String INPUT = "";

    void solve()
    {
        int n = ni();
        int[] a = na(n);
        int[] b = na(n);
        int[] as = new int[1000001];
        for(int v : a){ // mark elements to operate on  as array
            as[v] = 1;
        }
        for(int i = 1000000;i >= 1;i--){ // mark all factors of a array
            for(int j = i*2;j <= 1000000;j+=i){
                as[i] |= as[j];
            }
        }
        int[] bs = new int[1000001];
        for(int v : b){ //mark elements to operate on  bs array
            bs[v] = 1;
        }
        for(int i = 1000000;i >= 1;i--){ //  mark all factors of b array
            for(int j = i*2;j <= 1000000;j+=i){
                bs[i] |= bs[j];
            }
        }
        int G = -1;
        for(int i = 1000000;i >= 1;i--){
            if(as[i] == 1 && bs[i] == 1){
                G = i;// find greatesr factor
                break;
            }
        }
        long ret = 0;
        {
            int maxa = 0;
            for(int v : a){
                if(v % G == 0){
                    maxa = Math.max(maxa, v);
                }
            }
            ret += maxa;
        }
        {
            int maxb = 0;
            for(int v : b){
                if(v % G == 0){
                    maxb = Math.max(maxb, v);
                }
            }
            ret += maxb;
        }
        out.println(ret);
    }

    void run() throws Exception
    {
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        long s = System.currentTimeMillis();
        solve();
        out.flush();
        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");
    }

    public static void main(String[] args) throws Exception { new FindGCDEfficient().run(); }

    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;

    private int readByte()
    {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }

    private double nd() { return Double.parseDouble(ns()); }
    private char nc() { return (char)skip(); }

    private String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    private char[] ns(int n)
    {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    private char[][] nm(int n, int m)
    {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }

    private int[] na(int n)
    {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }

    private int ni()
    {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private long nl()
    {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }

        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    private static void tr(Object... o) { System.out.println(Arrays.deepToString(o)); }
}

