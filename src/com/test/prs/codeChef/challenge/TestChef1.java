package com.test.prs.codeChef.challenge;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestChef1 {

    public static void main(String[] args) throws IOException {
       /* BufferedReader ip = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(ip.readLine());*/
       Scanner s = new Scanner(System.in);
       int t = Integer.parseInt(s.nextLine());
        for(int i=1;i<=t;i++){
            int n = Integer.parseInt(s.nextLine());
            Set<String> a = new HashSet<>();

            for(int j=0;j<n;j++) {
                String str = s.nextLine();
                if(str.equals("easy-medium"))
                    str="medium";
                else if(str.equals("medium-hard"))
                    str="hard";
                a.add(str);
            }
            System.out.println(a.size()<5?"No":"Yes");
            /*int a1=0,a2=0,a3=0,a4=0,a5=0;
            for(int k=0;k<n;k++){
                if(a.contains("cakewalk"))
                    a1++;
                if(a.contains("simple"))
                    a2++;
                if(a[k].equals("easy"))
                    a3++;
                if(a[k].equals("easy-medium") || a[k].equals("medium"))
                    a4++;
                if(a[k].equals("medium-hard") || a[k].equals("hard"))
                    a5++;
            }
            if(a1==1&&a2==1&&a3==1&&a4==1&&a5==1)
                System.out.println("Yes");
            else
                System.out.println("No");
*/
        }
    }

}

/*
import java.io.IOException;
        import java.util.HashSet;
        import java.util.Scanner;
        import java.util.Set;

public class TestChef1 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.valueOf(scanner.nextLine());

        for(int i=0; i<tests; i++) {
            int n = Integer.valueOf(scanner.nextLine());

            // identify
            Set<String> aux = new HashSet<>();
            for(int j=0; j<n; j++) {
                String problemType = scanner.nextLine();
                if("easy-medium".equals(problemType))
                    problemType = "medium";
                else if("medium-hard".equals(problemType))
                    problemType = "hard";

                aux.add(problemType);
            }

            System.out.println(aux.size() < 5 ? "No" : "Yes");
        }

    }
}*/

