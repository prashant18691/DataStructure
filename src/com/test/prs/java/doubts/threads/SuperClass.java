package com.test.prs.java.doubts.threads;

public abstract class SuperClass {

    public SuperClass() {
        new Thread("evil") {
            public void run() {
            doSomethingDangerous();
            }
        }.start();
        try {
            Thread.sleep(5000);
        }
        catch(InterruptedException ex) { /* ignore */ }
    }

    public abstract void doSomethingDangerous();

}

