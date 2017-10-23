package com.test.prs.string;

public class TestStringDuplicate {

    public void findDuplicates(String text){
        if(text==null)
            return;
       char[] charArr = text.toCharArray();
       for(int i=0;i<charArr.length;i++){
           System.out.println(charArr[i]+" : "+countOccurences(text,charArr[i],i));
       }
    }

    private static int countOccurences(
            String someString, char searchedChar, int index) {
        if (index >= someString.length()) {
            return 0;
        }

        int count = someString.charAt(index) == searchedChar ? 1 : 0;
        return count + countOccurences(
                someString, searchedChar, index + 1);
    }

    public static void main(String[] args){
        TestStringDuplicate test = new TestStringDuplicate();
        test.findDuplicates("abaabbccc");
    }
}
