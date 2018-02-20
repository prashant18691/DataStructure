package com.test.prs.java.doubts.threads;

public class MultipleOfNumber {

    public static void main(String[] args) {

        PrintNumber p = new PrintNumber();

        PrintResult p3 = new PrintResult(3,p);
        PrintResult p4 = new PrintResult(4,p);
        PrintResult p5 = new PrintResult(5,p);
        p3.setName("T3");
        p4.setName("T4");
        p5.setName("T5");
        p3.start();
        p4.start();
        p5.start();
    }

}



class PrintResult extends Thread{

    Integer num;
    PrintNumber p ;
    int i=1;
    public PrintResult(Integer num, PrintNumber p) {
        super();
        this.num = num;
        this.p = p;
    }

    public void run(){

        while(i<20){
            if(num == 3){
                p.printThree(num*i);
            }
            else if(num==4){
                p.printFour(num*i);
            }
            else if(num == 5){
                p.printFive(num*i);
            }
            i++;
        }
    }
}

class PrintNumber{


    Integer flag = 0;

    public synchronized void printThree(Integer num){

        if(flag == 1){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
        flag = 1;
        notify();


    }
    public synchronized void printFour(Integer num){

        if(flag == 2){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
        flag = 2;
        notify();


    }

    public synchronized void printFive(Integer num){

        if(flag == 3){
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
        flag = 3;
        notify();


    }
}
