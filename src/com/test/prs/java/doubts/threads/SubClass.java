package com.test.prs.java.doubts.threads;

public class SubClass extends SuperClass {
    int number;
    public SubClass () {
        super();
        number = 2;
    }

    public  void doSomethingDangerous() {
        if(number == 2) {
            System.out.println("everything OK");
        }
        else {
            System.out.println("we have a problem.");
        }
    }

}
