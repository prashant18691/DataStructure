package com.test.prs.java.doubts.threads;



public class PrintMultiples345{
    int count ;
    int max ;
    int flag = 0;

    public PrintMultiples345(int count, int max) {
        this.count = count;
        this.max = max;
    }

    public void printMultiple3(){
        synchronized (this){
            while (count<=max){
                try {
                    Thread.sleep(1000);
                    while(count%3!=0) {
                        flag++;
                        if (flag==3) {
                            count++;
                            flag =0;
                            notifyAll();
                        }
                        else if (count<=max)
                        wait();
                    }
                    flag =0;
                    if (count<=max)
                    System.out.println(Thread.currentThread().getName() + " "+count++);
                    notifyAll();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public void printMultiple4(){
        synchronized (this){
            while (count<=max){
                try {
                    Thread.sleep(1000);
                    while(count%4!=0) {
                        flag++;
                        if (flag==3) {
                            count++;
                            flag =0;
                            notifyAll();
                        }
                        else if (count<=max)
                        wait();
                    }
                    flag =0;
                    if (count<=max)
                    System.out.println(Thread.currentThread().getName() + " "+count++);
                    notifyAll();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public void printMultiple5(){
        synchronized (this){
            while (count<=max){
                try {
                    Thread.sleep(1000);
                    while(count%5!=0) {
                        flag++;
                        if (flag==3) {
                            count++;
                            flag =0;
                            notifyAll();
                        }
                        else if (count<=max)
                        wait();
                    }
                    flag =0;
                    if (count<=max)
                    System.out.println(Thread.currentThread().getName() + " "+count++);
                    notifyAll();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintMultiples345 printMultiples345 = new PrintMultiples345(1,20);
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




