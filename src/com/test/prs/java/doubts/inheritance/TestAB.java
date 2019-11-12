package com.test.prs.java.doubts.inheritance;

 class A {
    void draw(){
        System.out.println("Base");
        System.out.println(this.getClass().getCanonicalName());
        System.out.println(super.getClass().getCanonicalName());
    }
}

class B extends A{
    @Override
    void draw() {
        System.out.println("Derived");
        System.out.println(this.getClass().getCanonicalName());
        System.out.println(super.getClass().getCanonicalName());
        super.draw();
    }
}

public class TestAB{
    public static void main(String[] args) {
        A a = new B();
        a.draw();
    }
}
