package com.test.prs.java.doubts.threads.locks.deadlock;

 class BankAccount {
    int id;
    double balance;

    public BankAccount(int id, double balance) {
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

    static void trasnsfer(BankAccount fromAcc, BankAccount toAcc, double amount){
        synchronized (fromAcc){
            fromAcc.withdraw(amount);
            synchronized (toAcc){
                toAcc.deposit(amount);
            }
        }
        System.out.println(Thread.currentThread().getName()+" completed");
    }

    public static void main(String[] args) {
        BankAccount fooAcc = new BankAccount(1,100d);
        BankAccount barAcc = new BankAccount(2,10d);
        new Thread("T1"){
            @Override
            public void run() {
                trasnsfer(fooAcc,barAcc,10d);
            }
        }.start();
        new Thread("T2"){
            @Override
            public void run() {
                trasnsfer(barAcc,fooAcc,10d);
            }
        }.start();
    }
}
