package com.test.prs.challenges;

public class TestDuplicates {
    public static int[] removeDuplicates(int[] input){

        int j = 0;
        int i = 1;
        //return if the array length is less than 2
        if(input.length < 2){
            return input;
        }
        while(i < input.length){
            if(input[i] == input[j]){
                i++;
            }else{
                input[++j] = input[i++];
            }
        }
        int[] output = new int[j+1];
        for(int k=0; k<output.length; k++){
            output[k] = input[k];
        }

        return output;
    }

    public static void main(String a[]){
        int[] input1 = {2,2,2,6,6,8};
        int[] output = removeDuplicates(input1);
        for(int i:output){
            System.out.print(i+" ");
        }

       /* BigInteger s1 = new BigInteger("blah".getBytes());
        BigInteger s2 = new BigInteger("bla".getBytes());
        System.out.println(s1+"  "+s2);
        System.out.println(s1.xor(s2));*/
    }
}
