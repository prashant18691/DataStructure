package com.test.prs.codeChef.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class TestPeriodicity {

    public static void main(String[] args) throws IOException {
        /*Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        String[] output = new String[t];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(s.next());
            int p = Integer.parseInt(s.next());
            output[i] = isPeriodicPalindrom(n, p);
        }
        for(String str:output)
          System.out.println(str);*/


        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t,i,j,q,n,p;
        String s,w;

        t = Integer.parseInt(br.readLine());
        while(t--!=0)
        {
            s = br.readLine();
            q = s.indexOf(' ');
            n = Integer.parseInt(s.substring(0,q));
            p = Integer.parseInt(s.substring(q+1));
            w="";

            if(p<3)
                System.out.println("impossible");
            else if(p==n)
            {
                if(p%2==0)
                {
                    for(i=0;i<p;i++)
                    {
                        if(i==(p/2) || i==((p/2)-1))
                            System.out.print('b');
                        else
                            System.out.print('a');
                    }
                }
                else
                {
                    for(i=0;i<p;i++)
                    {
                        if(i==(p/2))
                            System.out.print('b');
                        else
                            System.out.print('a');
                    }
                }
                System.out.println();
            }
            else
            {
                if(p%2==0)
                {
                    for(i=0;i<p;i++)
                    {
                        if(i==(p/2) || i==((p/2)-1))
                            w=w+'b';
                        else
                            w=w+'a';
                    }
                }
                else
                {
                    for(i=0;i<p;i++)
                    {
                        if(i==(p/2))
                            w=w+'b';
                        else
                            w=w+'a';
                    }
                }
                for(j=0;j<(n/p);j++)
                    System.out.print(w);
                System.out.println();
            }
        }*/


        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        long t,i,j,n,d,p;
        t=Long.parseLong(br.readLine());
        while(t!=0)
        {
            String x=br.readLine();
            String[] arr=x.split(" ");
            n=Long.parseLong(arr[0]);
            p=Long.parseLong(arr[1]);
            // System.out.print(t+" sd "+n+" sd "+p);
            //String a="",res="";
            StringBuilder a = new StringBuilder();
            StringBuilder res = new StringBuilder();
            d=n/p;
            if(p<3)
            {
                System.out.println("impossible");
            }
            else
            {
                a=a.append("a");
                for(i=1;i<p-1;i++)
                {
                    a=a.append("b");
                }
                a=a.append("a");

                for(i=1;i<=d;i++)
                {
                    res=res.append(a);
                }
                System.out.println(res);
            }
            t--;
        }
    }

    private static String isPeriodicPalindrom(int n, int p) {
        if (n%p == 0) {
          List<String> l =   createStrPerm(n);
            for(String s:l) {
                if(checkPalindrome(s) && s.indexOf("a") != -1 && s.indexOf("b") != -1) {
                    for (int i = 0; i < n; i++) {
                        if (s.charAt(i) == s.charAt((i+p)%n))
                            return s;
                        else
                            break;
                    }
                }
            }
        }

        return "impossible";
    }

    private static boolean checkPalindrome(String s) {
        String reverse = isPalindrome(s);
        return reverse.equals(s);
    }

    private static String isPalindrome(String s) {
        int length = s.length();
        if(length==1)
            return s;
        String last= s.substring(length-1);
        return last+isPalindrome(s.substring(0,length-1));
    }

    private static List<String> createStrPerm(int n) {
        String[] set = {"a", "b"};
        int k = set.length;
        List l = new ArrayList<>();
        createStrPermRec(set, "", n, k,l);// n length of string to be generated; k length of set
        return l;
    }

    private static void createStrPermRec(String[] set, String prefix, int n, int k,List l) {
        if(n==0) {
            l.add(prefix);
            return;
        }
        for(int i=0;i<k;i++){
            String newPrefix = prefix+set[i];
            createStrPermRec(set,newPrefix,n-1,k,l);
        }
    }

}
