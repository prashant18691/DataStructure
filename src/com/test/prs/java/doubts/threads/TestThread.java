package com.test.prs.java.doubts.threads;


public class TestThread{
    public static void main(String[] args) {
        Thread t3 = new Thread(new PrintNumber(3,1,100),"T3");
        Thread t4 = new Thread(new PrintNumber(4,1,100),"T4");
        Thread t5 = new Thread(new PrintNumber(5,1,100),"T5");
        t3.start();t4.start();t5.start();
    }

}
class PrintNumber implements Runnable{
     static Object obj = new Object();
     int start;
     int end;
     int multiple;

    public PrintNumber(int multiple,int start, int end) {
        this.start = start;
        this.end = end;
        this.multiple=multiple;
//        obj = new Object();
    }

    @Override
    public void run() {
            synchronized (obj){
                while (start<end){
                    if (start%multiple==0)
                        System.out.println(start++);
                }
            }
    }
}




