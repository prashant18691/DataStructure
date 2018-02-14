package com.test.prs.java.doubts.threads;



public class PrintMultiples345{
    int count ;
    int max ;

    public PrintMultiples345(int count, int max) {
        this.count = count;
        this.max = max;
    }

    public void printMultiple3(){
        synchronized (this){
            while (count<=max){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                while(count%3!=0) {
                    try {
                        wait();
                    } catch (InterruptedException e1) {
                    e1.printStackTrace();
                    }
                }
                    System.out.println(Thread.currentThread().getName()+" " + count++);
                    notifyAll();

            }
        }
    }

    public void printMultiple4(){
        synchronized (this){
            while (count<=max){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                while(count%4!=0) {
                    try {
                        wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" " + count++);
                notifyAll();

            }
        }
    }

    public void printMultiple5(){
        synchronized (this){
            while (count<=max){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                while(count%5!=0) {
                    try {
                        wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+" " + count++);
                notifyAll();

            }
        }
    }

    public static void main(String[] args) {
        PrintMultiples345 printMultiples345 = new PrintMultiples345(3,20);
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                printMultiples345.printMultiple3();
            }
        },"T3");
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                printMultiples345.printMultiple4();
            }
        },"T4");
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                printMultiples345.printMultiple5();
            }
        },"T5");
        t3.start();
        t4.start();
        t5.start();
        try {
        t3.join();
        t4.join();
        t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}




