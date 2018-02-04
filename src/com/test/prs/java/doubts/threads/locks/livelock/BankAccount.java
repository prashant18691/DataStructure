package com.test.prs.java.doubts.threads.locks.livelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    int id;
    double balance;
    Lock lock = new ReentrantLock();

    public BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public boolean withdraw(double amount){
        if(this.lock.tryLock()){
            try{Thread.sleep(1000);} catch (InterruptedException e){};
            this.balance-=amount;
            System.out.println((Thread.currentThread().getName().equals("T1")?"fooAcc Withdrawn":"barAcc Withdrawn"));
            return true;
        }
        return false;
    }

    public boolean deposit(double amount){
        if(this.lock.tryLock()){
            try{Thread.sleep(1000);} catch (InterruptedException e){};
            this.balance+=amount;
            System.out.println((Thread.currentThread().getName().equals("T1")?"fooAcc deposited":"barAcc deposited"));
            return true;
        }
        return false;
    }

    public boolean tryTransaction(BankAccount destinationAcc, double amount){
       if(this.withdraw(amount)){
           if(destinationAcc.deposit(amount))
            return true;
           else
               this.deposit(amount);
       }
       return false;
    }

    public static void main(String[] args) {
        BankAccount fooAcc = new BankAccount(1,100d);
        BankAccount barAcc = new BankAccount(2,100d);
        new Thread(new Transaction(fooAcc,barAcc,10d),"T1").start();
        new Thread(new Transaction(barAcc,fooAcc,10d), "T2").start();
    }
}

class Transaction implements Runnable{
    BankAccount sourceAcc,destinationAccount;
    double amount;

    public Transaction(BankAccount sourceAcc, BankAccount destinationAccount, double amount) {
        this.sourceAcc = sourceAcc;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        while(!sourceAcc.tryTransaction(destinationAccount,amount))
            continue;
        System.out.println("Transaction Completed "+Thread.currentThread().getName());
    }
}