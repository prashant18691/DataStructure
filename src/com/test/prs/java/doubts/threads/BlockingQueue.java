package com.test.prs.java.doubts.threads;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

    private List queue = new LinkedList();
    private int  limit = 10;

    public BlockingQueue(int limit){
        this.limit = limit;
    }


    public synchronized void enqueue(Object item)
            throws InterruptedException  {
        while(this.queue.size() == this.limit) {
            System.out.println("Queue full :: Producer waiting");
            wait();
        }
        if(this.queue.size() == 0) {
            System.out.println("?? producer");
            notifyAll();
        }
        this.queue.add(item);
    }


    public synchronized Object dequeue()
            throws InterruptedException{
        while(this.queue.size() == 0){
            System.out.println("Queue empty :: Consumer waiting");
            wait();
        }
        if(this.queue.size() == this.limit){
            System.out.println("?? consumer");
            notifyAll();
        }

        return this.queue.remove(0);
    }

    public static void main(String[] args) {
        int limit = 5;
        BlockingQueue queue = new BlockingQueue(limit);
        Thread producer = new Thread(()->{
            while(true) {
                try {
                    Thread.sleep(1000);
                    Integer a = Integer.valueOf((int) (System.currentTimeMillis()%10));
                    System.out.println("Produced :: "+a);
                    queue.enqueue(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(()->{
            while(true) {
                try {
                    Thread.sleep(5000);
                    Integer a = (int)queue.dequeue();
                    System.out.println("consumed :: "+a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }

}
