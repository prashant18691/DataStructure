package com.test.prs.java.doubts.threads.locks.livelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount implements Comparable<BankAccount>{
    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                ", lock=" + lock +
                '}';
    }

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
            if(this.balance>=amount) {
                this.balance -= amount;
            }
            else{
                System.out.println("Not enough balance");
                return false;
            }
            System.out.println(("Withdrawn "+Thread.currentThread().getName())+" "+this);
            return true;
        }

        return false;
    }

    public boolean deposit(double amount){
        if(this.lock.tryLock()){
            try{Thread.sleep(1000);} catch (InterruptedException e){};
            this.balance+=amount;
            System.out.println("Deposited "+Thread.currentThread().getName()+" "+this);
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

    @Override
    public int compareTo(BankAccount o) {
        return this.id-o.id;
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
        BankAccount first = sourceAcc;
        BankAccount second = destinationAccount;
        if(first.compareTo(second)>0) {
            first = destinationAccount;
            second = sourceAcc;
        }
        while(!first.tryTransaction(second,amount))
            continue;
        System.out.println("Transaction Completed "+Thread.currentThread().getName());
    }
}