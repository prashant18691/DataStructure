package com.test.prs.heap;

import java.util.*;

public class FindMedianHeap {
    private static Queue<Integer> maxHeapLeft ;
    private static Queue<Integer> minHeapRight;
    private static float median = 0.0f;

    public FindMedianHeap(){
        maxHeapLeft = new PriorityQueue<>(11,new MaxHeapComparator());
        minHeapRight =new PriorityQueue<>(11,new MinHeapComparator());
    }
    private static class MinHeapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1>o2?1:o1==o2?0:-1;
        }
    }

    private static class MaxHeapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1>o2?-1:o1==o2?0:1;
        }
    }
    static float solve(int curr) {
        if (maxHeapLeft.size() > minHeapRight.size()) {
            if (curr > median) {
                minHeapRight.add(curr);
            } else {
                minHeapRight.add(maxHeapLeft.poll());
                maxHeapLeft.add(curr);
            }
        } else if (maxHeapLeft.size() == minHeapRight.size()) {
            if (curr > median) {
                minHeapRight.add(curr);
            } else {
                maxHeapLeft.add(curr);
            }
        } else {
            if(curr>median){
                maxHeapLeft.add(minHeapRight.poll());
                minHeapRight.add(curr);
            }
            else{
                maxHeapLeft.add(curr);
            }

        }

        if (maxHeapLeft.size() > minHeapRight.size())
            median = maxHeapLeft.peek();
        else if(maxHeapLeft.size() == minHeapRight.size()){
            median = (maxHeapLeft.peek()+minHeapRight.peek())/2f;
        }
        else
            median =minHeapRight.peek();


        return median;
    }


    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        FindMedianHeap heap = new FindMedianHeap();
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            System.out.println(solve(s.nextInt()));
        }
    }
}
