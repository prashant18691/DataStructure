package com.test.prs.challenges;

import java.io.IOException;

public class TestException2 {
    public static void main(String[] args) throws T1, T2{
        int a = 10;

        if(a==10)
            throw new T1();
        else if(a==20)
            throw new T2();
        else {
            throw new CE();
        }
    }
}

class T1 extends Exception{ // checked Exception
    @Override
    public void printStackTrace() {
       System.out.println("T1");
    }
}
class T2 extends Exception{// checked Exception
    @Override
    public void printStackTrace() {
        System.out.println("T2");
    }
}
class CE extends RuntimeException{// extends RuntimeException, so unchecked Exception
    @Override
    public void printStackTrace() {
        System.out.println("T2");
    }
}
