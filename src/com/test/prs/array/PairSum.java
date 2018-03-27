package com.test.prs.array;

import com.test.prs.avltree.AVLTree;

import java.util.*;

class PairSum

{

    public static int sumPairs(Integer[] input, int k){
        Map<Integer, Integer> frequencies = new HashMap<>();
        int pairsCount = 0;

        for(int i=0; i<input.length; i++){
            int value = input[i];
            int complement = k - input[i];

            if(frequencies.containsKey(complement)){
                int freq = frequencies.get(complement) - 1;
                pairsCount++;
                //System.out.println(value + ", " + complement);
                if(freq == 0){
                    frequencies.remove(complement);
                }else{
                    frequencies.put(complement, freq);
                }
            }else{
                if(frequencies.containsKey(value)){
                    frequencies.put(value, frequencies.get(value) + 1);
                }else{
                    frequencies.put(value, 1);
                }
            }
        }
        return pairsCount;
    }

    public static int sumPairs1(Integer[] input, int sum){
        List<Integer> complementaries = new ArrayList<>(input.length);
        int pairs = 0;
        for(Integer number : input){
            if(complementaries.contains(number)){
                complementaries.remove(number);
                pairs++;
            }
            else{
                complementaries.add(sum-number);
            }
        }
        return pairs;
    }


    public static int avlTreeSolution(int[] input, int sum){
        AVLTree tree = new AVLTree();
        for (Integer i : input)
            tree.root = tree.insert(tree.root,i);
        int count = 0;
        for (int i = 0; i < input.length ; i++) {
            if (tree.search(tree.root,sum-input[i]))
                count++;
            tree.root=tree.delete(tree.root,input[i]);
        }
        return count;
    }


    public static void main (String[] args)
    {
        int A[] = {5,5,5,5,5,5};
        int k = 10;

        int tot = avlTreeSolution(A, k);
        System.out.println(tot);
    }


    public static int correctSolution(int[] a, long k) {
        boolean hasDuplicatedDivisor = false;
        HashSet<Long> nums = new HashSet<Long>();
        for(int i=0;i<a.length;i++){
            if(a[i]*2==k && nums.contains((long)a[i])){
                hasDuplicatedDivisor = true;
                break;
            }else{
                nums.add((long)a[i]);
            }
        }
        nums.remove(k /2);
        Iterator<Long> it = nums.iterator();
        int tot = hasDuplicatedDivisor? 1:0;
        while(it.hasNext()){
            Long req = it.next();
            if(nums.contains(k-req)){
                tot ++;
                it.remove();
            }
        }
        return tot;
    }
}
