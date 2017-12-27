package com.test.prs.heap;

import java.util.Scanner;

public class FindMedianHeapCustom {

    private static MaxHeap heapLeft = new MaxHeap();
    private static MinHeap heapRight = new MinHeap();
    private static float median = 0.0f;

    public static void solve(int curr){
        if(heapLeft.size>heapRight.size){
            if(curr>median){
                heapRight.add(curr);
            }
            else{
                heapRight.add(heapLeft.poll());
                heapLeft.add(curr);
            }
        }
        else if(heapLeft.size==heapRight.size){
            if(curr>median)
                heapRight.add(curr);
            else
                heapLeft.add(curr);
        }
        else{
            if(curr>median){
                heapLeft.add(heapRight.poll());
                heapRight.add(curr);
            }
            else{
                heapLeft.add(curr);
            }
        }

        if(heapLeft.size>heapRight.size)
            median = heapLeft.peek();
        else if(heapLeft.size==heapRight.size)
            median = (heapLeft.peek()+heapRight.peek())/2f;
        else
            median = heapRight.peek();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i=0;i<n;i++){
            solve(s.nextInt());
            System.out.println(median);
        }
    }
}
