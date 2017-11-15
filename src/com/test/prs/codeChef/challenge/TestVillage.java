package com.test.prs.codeChef.challenge;

import java.util.Scanner;

class TestVillage{

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        String[] strArr = new String[t];
        for(int i=0;i<t;i++){
            strArr[i] = s.nextLine();
        }
        s.close();
            if(strArr.length<1)
                System.out.println(0+" "+0);
        for(String str : strArr)
            findVillageCount(str);

    }

    private static void findVillageCount(String str) {
        char[] strChar = str.toCharArray();
        int aCount=0;
        int bCount=0;
        int length = strChar.length;
        int lastIndex = -1;
        for(int i=0;i<length;i++){
            if(strChar[i]=='A') {
                aCount++;
                if(lastIndex>-1 && strChar[lastIndex]=='B'){
                    bCount-=(i-lastIndex-1);
                }
                lastIndex=i;
            }
            else if(strChar[i]=='B') {//A..A..B...B
                bCount++;
                if(lastIndex>-1 && strChar[lastIndex]=='A'){
                    aCount-=(i-lastIndex-1);
                }
                lastIndex=i;
            }
            else if(strChar[i]=='.'){
                if(lastIndex>-1) {
                    if (strChar[lastIndex] == 'A')
                        aCount++;
                    else if (strChar[lastIndex] == 'B')
                        bCount++;
                }
               /* if(i==length-1)
                    lastIndex=-1;*/
            }
        }
        if(lastIndex>-1) {
            if (strChar[lastIndex] == 'A')
                aCount -= (length - lastIndex - 1);
            else if (strChar[lastIndex] == 'B')
                bCount -= (length - lastIndex - 1);
        }

        System.out.println(aCount+" "+bCount);
    }


}
