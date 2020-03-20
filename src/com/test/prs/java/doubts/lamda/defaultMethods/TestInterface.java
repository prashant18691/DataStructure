package com.test.prs.java.doubts.lamda.defaultMethods;

public class TestInterface {
    public static void main(String[] args) {
        Interface1 interface1 = new MyClass();
        interface1.log("hello");

        Interface2 interface2 = new MyClass();
        interface2.log("hi");
    }
}
