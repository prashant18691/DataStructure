package com.test.prs.java.doubts.threads.locks.lockstarvation;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    int id;
    double balance;
    Lock lock = new ReentrantLock();

    public double getBalance() {
        return balance;
    }


    public BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public boolean withdraw(double amount){
        if(this.lock.tryLock()){
            try{Thread.sleep(1000);} catch (InterruptedException e){};
            this.balance-=amount;
            System.out.println("fooAcc Withdrawn; Balance : "+ getBalance());
            return true;
        }
        return false;
    }

    public boolean deposit(double amount){
        if(this.lock.tryLock()){
            try{Thread.sleep(1000);} catch (InterruptedException e){};
            this.balance+=amount;
            System.out.println("barAcc Withdrawn; deposied : "+ getBalance());
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
        BalanceMonitor balanceMonitor = new BalanceMonitor(fooAcc);
        Thread balanceThread = new Thread(balanceMonitor,"Monitoring...");
        Thread t1 = new Thread(new Transaction(fooAcc,barAcc,100d),"T1");
        Thread t2 = new Thread(new Transaction(fooAcc,barAcc,100d), "T2");
        balanceThread.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        balanceThread.start();
        try{Thread.sleep(1000);}catch (InterruptedException e){}
        t1.start();
        t2.start();
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

class BalanceMonitor implements Runnable{
    BankAccount acc;

    public BalanceMonitor(BankAccount acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        while(true)
            if(acc.getBalance()<=0)
            {
                System.out.println("Zero Balance");

                break;
            }
        System.out.println("Current Balance : "+acc.getBalance());
    }
}