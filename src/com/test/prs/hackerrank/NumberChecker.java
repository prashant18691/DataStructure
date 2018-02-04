package com.test.prs.hackerrank;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberChecker {

    static final int[] index = {1,2,3};
    /*
     * Complete the function below.
     */
    static String findQualifiedNumbers(int[] arr) {
        StringBuilder sb = new StringBuilder("");
        String regex = "[123]{3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = null;
        for(int i : arr) {
            String str = String.valueOf(i);
            matcher = pattern.matcher(str);
            if(matcher.find())
                sb.append(str+",");
        }

       /* Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.indexOf("2")-o2.indexOf("1")  ;
            }
        });*/

        if(sb.length()==0)
            sb.append("-1 ");
        return sb.toString().substring(0,sb.length()-1);

        }

    private static boolean checkNumber(int[] arr) {
        int range = 3 - 1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            if (Math.abs(arr[i]) >= 1 &&
                    Math.abs(arr[i]) <= 3) {


                int z = Math.abs(arr[i]) - 1;
                if (arr[z] > 0) {
                    arr[z] = arr[z] * -1;
                }
            }
        }

        int count=0;

        for (int i = 0; i <= range && i<n; i++) {

            if (arr[i] > 0)
                return false;
            else
                count++;
        }

        if(count!= (range+1))
            return false;

        return true;
    }


    public static void main(String[] args) {

        /*Scanner s = new Scanner(System.in);
        int n = s.nextInt();
           int[] ip = new int[n];
           for(int i=0;i<n;i++)
               ip[i] = s.nextInt();*/
           int[] i = {1456,345671,41238,3321};
//        System.out.println(findQualifiedNumbers(i));
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        Map<String,Integer> map = new HashMap<>();
        for(String s : magazine){
            if(!map.containsKey(s))
                map.put(s,1);
            else
                map.put(s,map.get(s)+1);
        }

        /*Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer> entry = it.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }*/

        for(String s : ransom){
            Integer count = map.get(s);
            if(count==null){
                System.out.println("No");
                return;
            }
            map.put(s,--count);
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue()<0){
                System.out.println("No");
                break;
            }
        }
        System.out.println("Yes");


    }
}
