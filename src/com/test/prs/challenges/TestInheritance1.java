package com.test.prs.challenges;

public class TestInheritance1 {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
       /* a1.hello();
        a2.hello();*/
        a1=null;
        a2=null;
        System.gc();

    }

}

class A {
    public A() {
        System.out.println("A constructor");
    }

    @Override
    protected void finalize(){System.out.println("A finalize called");}
    void hello(){
        System.out.println("Hello from A");
    }
}

class B extends A{
    public B() {
        System.out.println("B constructor");
    }
    @Override
    protected void finalize(){System.out.println("B finalize called");}
    @Override
    void hello(){
        System.out.println("Hello from B");
    }
}
