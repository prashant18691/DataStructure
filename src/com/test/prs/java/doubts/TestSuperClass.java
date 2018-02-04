package com.test.prs.java.doubts;

import com.test.prs.java.doubts.threads.SubClass;
import com.test.prs.java.doubts.threads.SuperClass;

public class TestSuperClass {
    public static void main(String[] args) {
        /*new Thread(""){
            public void run(){

            }
        }.start();*/

        SuperClass a =  new SubClass();
    }

}
