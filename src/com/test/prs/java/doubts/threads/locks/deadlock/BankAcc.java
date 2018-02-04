package com.test.prs.java.doubts.threads.locks.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

 class BankAcc {
    int id;
    double balance;
    final Lock lock = new ReentrantLock();

    public BankAcc(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    void withdraw(double amount){
        try{ Thread.sleep(1000);}catch (InterruptedException e){};
        this.balance-=amount;
    }

    void deposit(double amount){
        try{ Thread.sleep(1000);}catch (InterruptedException e){};
        this.balance+=amount;
    }

    static void trasnsfer(BankAcc fromAcc, BankAcc toAcc, double amount){
        fromAcc.lock.lock();
            fromAcc.withdraw(amount);
            toAcc.lock.lock();
                toAcc.deposit(amount);
             fromAcc.lock.lock();
        fromAcc.lock.unlock();
        System.out.println(Thread.currentThread().getName()+" completed");
    }

    public static void main(String[] args) {
        BankAcc fooAcc = new BankAcc(1,100d);
        BankAcc barAcc = new BankAcc(2,10d);
        new Thread(){
            @Override
            public void run() {
                trasnsfer(fooAcc,barAcc,10d);
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                trasnsfer(barAcc,fooAcc,10d);
            }
        }.start();
    }
}
