package com.test.prs.java.doubts.threads;

public class OddEvenPrintMain {

    boolean odd;
    int count = 1;
    int MAX = 20;

    public void printOdd() {
        synchronized (this) {
            while (count < MAX) {
                System.out.println("Checking odd loop");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                while (!odd) {
                    try {
                        System.out.println("Odd waiting : " + count);
                        wait();
                        System.out.println("Notified odd :" + count);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + count);
                count++;
                odd = false;
                notify();
            }
        }
    }

    public void printEven() {

        synchronized (this) {
            while (count < MAX) {
                System.out.println("Checking even loop");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                while (odd) {
                    try {
                        System.out.println("Even waiting: " + count);
                        wait();
                        System.out.println("Notified even:" + count);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + count);
                count++;
                odd = true;
                notify();

            }
        }
    }

    public static void main(String[] args) {

        OddEvenPrintMain oep = new OddEvenPrintMain();
        oep.odd = true;
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                oep.printEven();

            }
        },"Even thread ");
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                oep.printOdd();

            }
        },"Odd thread ");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
